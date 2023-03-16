package com.stg.excel_work.service;

import com.stg.excel_work.entity.Position;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FileService {
    List<Position> importPositions(InputStream inputStream) throws IOException;
    Map<String, ArrayList<String>> importBids(InputStream inputStream) throws IOException;
}
