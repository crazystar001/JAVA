package a;

import java.util.Scanner;

public class chess_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 3;// 棋盘默认大小
		
		size=sc.nextInt();//用户输入的棋盘大小
		
		if(size>=3 && size<=100){
			int[][] bord = new int[size][size];
			boolean isWin = false;
			// 计数行
			int numFX=0,numFO=0;
			// 计数列
			int numLFX=0,numLFO=0;
			// 读入矩阵
			for (int i = 0; i < bord.length; i++) {
				for (int k = 0; k < bord[i].length; k++) {
					bord[i][k] = sc.nextInt();
				}
			}
			// 游戏获胜一行都为X 或者都为O 则一方获胜
			// 检查行 与 列
			for (int i = 0; i < bord.length; i++) {
				numFX = 0;
				numFO = 0;
				numLFX = 0;
				numLFO = 0;
				for (int k = 0; k < bord[i].length; k++) {
					if (bord[i][k] == 1) {
						numFX++;
					} else {
						numFO++;
					}
					if (bord[k][i] == 1) {
						numLFX++;
					} else {
						numLFO++;
					}
				}
				
				if (numFX == size || numFO == size || numLFX == size || numLFO == size) {
					isWin = true;
					break;
				}
			}
			if(isWin==false){
				//检查斜线 与 反斜线
				for (int i = 0; i < bord.length; i++) {
					numFX = 0;
					numFO = 0;
					numLFX = 0;
					numLFO = 0;
					for (int k = 0; k < bord[i].length; k++) {
						if (bord[k][k] == 1) {
							numFX++;
						} else {
							numFO++;
						}
						if (bord[k][size-k-1] == 1) {
							numLFX++;
						} else {
							numLFO++;
						}
					}
					
					if (numFX == size || numFO == size || numLFX == size || numLFO == size) {
						isWin = true;
						break;
					}
				}
			}
			
			// 输出获胜信息
			if (isWin) {
				if (numFX == size||numLFX == size) {
					System.out.println("X胜");
				} else{
					System.out.println("O胜");
				}
			} else {
				System.out.println("无人获胜");
			}
			
		}else{
			System.out.println("超出限定大小，范围在3到99之间");
		}
		
	}
}
