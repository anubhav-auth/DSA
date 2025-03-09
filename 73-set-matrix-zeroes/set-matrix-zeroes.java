class Solution {
    Boolean firstRowZero = false;
    Boolean firstColumnZero = false;

    public void setZeroes(int[][] matrix) {
        checkRowCol(matrix);
        traverseInside(matrix);
        finaliseZeros(matrix);
        finaliseFirsts(matrix);
    }

    public void checkRowCol(int [][] mat){
        for(int i = 0; i< mat.length; i++){
            if(i == 0){
                for(int j = 0; j< mat[0].length; j++){
                    if(mat[0][j] == 0) firstRowZero = true;
                }
            }
            if(mat[i][0] == 0) firstColumnZero = true;
        }
    }

    public void traverseInside(int [][] mat){
        for(int i = 1; i < mat.length; i++){
            for(int j = 1; j < mat[i].length; j++){
                if(mat[i][j] == 0){
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                }
            }
        }
    }

    public void finaliseZeros(int [][] mat){
        for(int i = 1; i< mat.length; i++){
            if(mat[i][0] == 0) {
                for(int j = 1; j< mat[i].length; j++){
                    mat[i][j] = 0;
                }
            }
        }
        for(int i = 1; i< mat[0].length; i++){
            if(mat[0][i] == 0) {
                for(int j = 1; j< mat.length; j++){
                    mat[j][i] = 0;
                }
            }
        }
    }

    public void finaliseFirsts(int [][] mat){
        if(firstRowZero){
            for(int i = 0; i<mat[0].length; i++){
                mat[0][i] = 0;
            }
        }
        if(firstColumnZero){
            for(int i = 0; i<mat.length; i++){
                mat[i][0] = 0;
            }
        }
    }
}