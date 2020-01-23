import java.util.*;

public class Queen4{
	private static boolean[][] arr = new boolean[4][4];
	private static boolean check(int x, int y){
		for(int i=0;i<4;i++){
			if(arr[x][i] || arr[i][y])
				return false;
			for(int j=0;j<4;j++)
				if(((x+y)==(i+j) || (x-i)==(y-j)) && arr[i][j])
					return false;
		}
		return true;
	}
	private static void showBoard(){
		System.out.println("\n   0 1 2 3 \n  ._______. ");
		for(int i=0;i<4;i++){
			System.out.print(i + " |");
			for(int j=0;j<4;j++){
				if(arr[i][j])
					System.out.print("0|");
				else
					System.out.print(".|");
			}
			System.out.println();
		}
	}
	private static void reset(){
		arr = new boolean[4][4];
	}
	private static boolean col(int c, int count){
		if(count>=4)
			return true;
		for(int i=0;i<4;i++){
			if(check(i,c)){
				arr[i][c] = true;
				if(col(((c+1)>3?(c-3):(c+1)), count+1))
					return true;
				else
					arr[i][c] = false;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		for(int i=0;i<2;i++){
			col(i,0);
			showBoard();
			reset();
		}
	}
}