package com.stg.excel_work.controller;


import com.stg.excel_work.entity.Position;
import com.stg.excel_work.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("web")
public class FileController {

    @Autowired
    private FileService fileService;
    @GetMapping("test")
    public ResponseEntity<String> testApi(){
        return ResponseEntity.ok("Working");
    }

    @PostMapping("upload/positions")
    public ResponseEntity<List<Position>> uploadPositionsFile(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(this.fileService.importPositions(file.getInputStream()));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("upload/bids")
    public ResponseEntity<Map<String , ArrayList<String>>> uploadBidsFile(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(this.fileService.importBids(file.getInputStream()));
        } catch (IOException e) {
            return null;
        }
    }
}
