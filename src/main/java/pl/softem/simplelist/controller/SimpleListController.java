package pl.softem.simplelist.controller;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SimpleListController {

    private List<String> elements = new ArrayList<>(Arrays.asList("Mleko", "Korba", "Pies"));

    @GetMapping("/elements")
    public String getElements() {
        Gson gson = new Gson();
        String jsonArray = gson.toJson(elements);
        return jsonArray;
    }

    @PostMapping(value = "/elements")
    public ResponseEntity<String> addElement(@RequestBody String element) {
        elements.add(element);
        return new ResponseEntity(element, HttpStatus.CREATED);
    }

    @DeleteMapping("/elements/{index}")
    public ResponseEntity<String> deleteElement(@PathVariable int index) {
        elements.remove(index);
        return new ResponseEntity("Element deleted", HttpStatus.OK);
    }
}
