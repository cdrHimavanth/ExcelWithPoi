package com.stg.excel_work.service.serviceimplementation;


import com.stg.excel_work.entity.Position;
import com.stg.excel_work.repository.PositionRepository;
import com.stg.excel_work.service.FileService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> importPositions(InputStream inputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("open position");
        int count = 0;
        List<Position> positions = new ArrayList<>();
        for (Row row : sheet) {
            if (count > 0) {
                Position position = new Position();
                position.setOrderNumber(row.getCell(0) != null ? (int) row.getCell(0).getNumericCellValue() : null);
                position.setNoOfPositions(row.getCell(1) != null ? (int) row.getCell(1).getNumericCellValue() : null);
                position.setRecruiter(row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null);
                position.setPositionBroadcastedDate(row.getCell(3) != null ? row.getCell(3).getDateCellValue() : null);
                position.setStratification(row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null);
                position.setTargetRate(row.getCell(5) != null ? (int) row.getCell(5).getNumericCellValue() : null);
                position.setSkillGroup(row.getCell(6) != null ? row.getCell(6).getStringCellValue() : null);
                position.setPrimarySkill(row.getCell(7) != null ? row.getCell(7).getStringCellValue() : null);
                position.setSkillset(row.getCell(8) != null ? row.getCell(8).getStringCellValue() : null);
                position.setJobDescription(row.getCell(9) != null ? row.getCell(9).getStringCellValue() : null);
                position.setPositionType(row.getCell(10) != null ? row.getCell(10).getStringCellValue() : null);
                position.setDidCustomerReachedOut(row.getCell(11) != null ? row.getCell(11).getStringCellValue() : null);
                position.setProbability(row.getCell(12) != null ? (int) row.getCell(12).getNumericCellValue() : null);
                position.setSubmittedAboveTarget(row.getCell(13) != null ? row.getCell(13).getStringCellValue() : null);
                position.setRegion(row.getCell(14) != null ? row.getCell(14).getStringCellValue() : null);
                position.setLineOfBusiness(row.getCell(15) != null ? row.getCell(15).getStringCellValue() : null);
                position.setProductLine(row.getCell(16) != null ? row.getCell(16).getStringCellValue() : null);
                position.setLl6(row.getCell(17) != null ? row.getCell(17).getStringCellValue() : null);
                position.setLL5(row.getCell(18) != null ? row.getCell(18).getStringCellValue() : null);
                position.setLL4(row.getCell(19) != null ? row.getCell(19).getStringCellValue() : null);
                position.setLL3(row.getCell(20) != null ? row.getCell(20).getStringCellValue() : null);
                positions.add(position);
            }

            count++;

        }
        workbook.close();
        return this.positionRepository.saveAll(positions);

    }

    @Override
    public Map<String, ArrayList<String>> importBids(InputStream inputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("bid info");
        Map<String, ArrayList<String>> map = new HashMap<>();
        int j = 0;

        for (Row row : sheet) {
            for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                if (i == 0) {
                    if (sheet.getRow(i).getCell(j) == null) {
                        break ;
                    } else if (!map.keySet().contains(sheet.getRow(i).getCell(j).toString())) {
                        map.put(sheet.getRow(i).getCell(j).toString(), new ArrayList<String>());
                    } else {
                        logger.info("Column duplicate found!!!!!!!!!!!!");
                    }
                } else {
                    ArrayList<String> newList = map.get(sheet.getRow(0).getCell(j).toString());
                    newList.add(this.check(sheet.getRow(i).getCell(j)));
                    map.put(sheet.getRow(0).getCell(j).toString(), newList);
                }

            }
            j++;
        }
        workbook.close();
        return map;
    }

    public String check(Cell cell) {
        String out = "";
        if (cell != null) {
            int cellType = cell.getCellType();

            switch (cellType) {
                case 0:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        out = out + cell.getDateCellValue() ;

                    } else {
                        out = out + cell.getNumericCellValue() ;
                    }
                    break;
                case 1:
                    out = out + cell.getStringCellValue() ;
                    break;
                case 2:
                    logger.info("Formula cell");
                    break;
                case 3:
                    logger.info("Blank cell");
                    break;
                case 4:
                    out = out + cell.getBooleanCellValue() ;
                    break;
                case 5:
                    logger.info("error");
                    break;
                default:
                    break;
            }

        }
        return out;
    }
}
