package com.hackereath.Connect_Four.DAO;


import com.hackereath.Connect_Four.Model.Matrix;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.hackereath.Connect_Four.ConnectFourApplication.gameLog;

@Repository("ValidORNot")
public class ValidORNot implements gameDAO{
    private final JdbcTemplate jdbcTemplate;
    private static Matrix matrix;
    public ValidORNot(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional StartTheGame() {
        UUID id = UUID.randomUUID();
        int[][] gameBox = new int[6][7];
        String sql = "INSERT INTO game (id,matrix) VALUES (?,?)";
        jdbcTemplate.update(sql,new Object[]{id,""});
        matrix = new Matrix(id,gameBox,'Y');
        return Optional.empty();
    }

    @Override
    public void UpdateDB(int[][] box) {
        List<Integer> MatrixBox = new ArrayList<Integer>();
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                MatrixBox.add(box[i][j]);
            }
        }
        String sql = "UPDATE game SET matrix = ? WHERE id = ?";
        jdbcTemplate.update(sql,new Object[]{MatrixBox.toString(),matrix.getId()});
        return;
    }

    @Override
    public String InsertTheCoin(int column) {
        int[][] box = matrix.getBox();
        char color = matrix.getColor();
        for(int i=box.length-1;i>=0;i--)
        {
            if(column <0 || column >7)
                return "Invalid";
            if(box[i][column] !=1 && box[i][column] !=2 && color == 'Y') {
                box[i][column ] = 1;
                matrix.setMatrix(box);
                matrix.setColor('R');
                char winner = CheckWinner(box,color,column,i);
                UpdateDB(box);
                if(winner != 'Z')
                    return "Yellow wins";
                return "Valid";
            }
            else if(box[i][column] !=1 && box[i][column] !=2 && color == 'R') {
                box[i][column] = 2;
                matrix.setMatrix(box);
                matrix.setColor('Y');
                char winner = CheckWinner(box,color,column,i);
                UpdateDB(box);
                if(winner != 'Z')
                    return "Red wins";
                return "Valid";
            }
        }
        return "Invalid";
    }

    @Override
    public char CheckWinner(int[][] box,char color,int column,int row) {
        int rowCount = 0,columnCount = 0,leftDiagonalCount = 0,rightDiagonalCount = 0;
        int temp = 0;
        if(color == 'Y')
        {
            temp = 1;
        }
        else{
            temp = 2;
        }

        for(int i=0;i<6;i++)
        {
            if(box[i][column]== temp)
                rowCount++;
            if(rowCount == 4)
                return color;
        }
        for(int i=0;i<7;i++)
        {
            if(box[row][i]== temp)
                columnCount++;
            if(columnCount == 4)
                return color;
        }
        for(int i = row,j=column;(i<6 && j < 7);i++,j++)
        {
            if(box[i][j] == temp)
                leftDiagonalCount++;
            if(leftDiagonalCount == 4)
                return color;
        }
        for(int i = row,j=column;(i>=0 && j>=0);i--,j--)
        {
            leftDiagonalCount = leftDiagonalCount -1;
            if(box[i][j] == temp)
                leftDiagonalCount++;
            if(leftDiagonalCount == 4)
                return color;
        }
        for(int i = row,j=column;(i<6 && j>=0);i++,j--)
        {
            if(box[i][j] == temp)
                rightDiagonalCount++;
            if(rightDiagonalCount == 4)
                return color;
        }
        for(int i = row,j=column;(i>=0 && j<7);i--,j++)
        {
            rightDiagonalCount = rightDiagonalCount - 1;
            if(box[i][j] == temp)
                rightDiagonalCount++;
            if(rightDiagonalCount == 4)
                return color;
        }
        return 'Z';
    }
}
