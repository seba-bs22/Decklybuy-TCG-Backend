package com.decklybuytcg.backend.service;

import com.decklybuytcg.backend.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final WebClient webClient;

    @Autowired
    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }

    private final String BASE_URL = "https://rhsyhwzlpqgecxycdilm.supabase.co/rest/v1/USER";

    // Keys
    private final String API_KEY_READ = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJoc3lod3pscHFnZWN4eWNkaWxtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjQ4NjYxNzMsImV4cCI6MjA4MDQ0MjE3M30.ochk-BP_YWWOfXRpTcOMVM622VVkLHvMYaCBLYRIKuE";
    private final String API_KEY_WRITE = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJoc3lod3pscHFnZWN4eWNkaWxtIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTc2NDg2NjE3MywiZXhwIjoyMDgwNDQyMTczfQ.Ks_HywIXq9T-ORb20HmZUd8n95oWHvtvmeCaT43Otis";

    // ------------------------------
    // GET ALL USERS
    // ------------------------------
    public List<UserDTO> getAllUsers() {
        UserDTO[] users = webClient.get()
                .uri(BASE_URL)
                .header("apikey", API_KEY_READ)
                .header("Authorization", "Bearer " + API_KEY_READ)
                .retrieve()
                .bodyToMono(UserDTO[].class)
                .block();

        return Arrays.asList(users != null ? users : new UserDTO[0]);
    }

    // ------------------------------
    // GET USER BY ID
    // ------------------------------
    public UserDTO getUserById(String id) {
        UserDTO[] users = webClient.get()
                .uri(BASE_URL + "?id=eq." + id)
                .header("apikey", API_KEY_READ)
                .header("Authorization", "Bearer " + API_KEY_READ)
                .retrieve()
                .bodyToMono(UserDTO[].class)
                .block();

        return (users != null && users.length > 0) ? users[0] : null;
    }

    // ------------------------------
    // SEARCH USERS BY NAME
    // ------------------------------
    public List<UserDTO> searchUsersByName(String nombre) {
        UserDTO[] users = webClient.get()
                .uri(BASE_URL + "?nombre=ilike.*" + nombre + "*")
                .header("apikey", API_KEY_READ)
                .header("Authorization", "Bearer " + API_KEY_READ)
                .retrieve()
                .bodyToMono(UserDTO[].class)
                .block();

        return Arrays.asList(users != null ? users : new UserDTO[0]);
    }

    // ------------------------------
    // CREATE USER (POST)
    // ------------------------------
    public UserDTO createUser(UserDTO user) {
        user.setId(null); // Supabase genera el id automáticamente

        UserDTO[] created = webClient.post()
                .uri(BASE_URL)
                .header("apikey", API_KEY_WRITE)
                .header("Authorization", "Bearer " + API_KEY_WRITE)
                .header("Content-Type", "application/json")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(UserDTO[].class)
                .block();

        return (created != null && created.length > 0) ? created[0] : null;
    }

    // ------------------------------
    // UPDATE USER (PATCH)
    // ------------------------------
    public UserDTO updateUser(String id, UserDTO user) {
        UserDTO[] updated = webClient.patch()
                .uri(BASE_URL + "?id=eq." + id)
                .header("apikey", API_KEY_WRITE)
                .header("Authorization", "Bearer " + API_KEY_WRITE)
                .header("Content-Type", "application/json")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(UserDTO[].class)
                .block();

        return (updated != null && updated.length > 0) ? updated[0] : null;
    }

    // ------------------------------
    // DELETE USER
    // ------------------------------
    public boolean deleteUser(String id) {
        return webClient.delete()
                .uri(BASE_URL + "?id=eq." + id)
                .header("apikey", API_KEY_WRITE)
                .header("Authorization", "Bearer " + API_KEY_WRITE)
                .retrieve()
                .toBodilessEntity()
                .map(resp -> resp.getStatusCode().is2xxSuccessful())
                .block();
    }
}
