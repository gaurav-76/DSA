public class SearchInMatrix{

    //Intuition
    //As matrix is sorted column and row wise
    //So we will be start traversing from [0][n-1]

    //0th row and n-1th column
    //When we get element > key we go left(column--)
    //when we get element < key we go down(row++)
    public void search(int[][] matrix, int key){

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols-1;

        while(i < rows && j >= 0){
            if(matrix[i][j] == key){
                System.out.println("Elemenet found at : " + i + ", " + j);
                return;
            }
            else if(matrix[i][j] > key){
                --j;
            }
            else{
                ++i;
            }
        }

        System.out.println("Element Not Found!!!");
    }

    public static void main(String[] args) {
        
        int[][] matrix = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 51}
                        };

        SearchInMatrix obj = new SearchInMatrix();
        obj.search(matrix, 32);
        obj.search(matrix, 51);
    }
}