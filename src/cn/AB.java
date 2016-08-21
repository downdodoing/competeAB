package cn;

import java.util.ArrayList;

public class AB {
	public String createString(int N, int K) {
		if ((2 > N || 50 < N) || (0 > K || N * (N - 1) / 2 < K)) {
			return "";
		}
		ArrayList<Character> mChar = new ArrayList<Character>(N);
		init(mChar, N);
		int i = 1;
		if (N > K) {
			mChar.set(N - 1 - K, 'A');
		} else {
			mChar.set(0, 'A');
			int mNumOfAB = mChar.size() - 1;// 因为K >= n;那么A必然在数组的第一个位置
			int leB = mNumOfAB;
			for (; leB < K && i < N; i++) {
				int lNum = K - leB + i;// 求出还需要多少对
				if (lNum < leB - 1) {
					mChar.set(N - 1 - lNum, 'A');
					break;
				} else {
					mChar.set(i, 'A');
					leB = N - i - 1;
					mNumOfAB = leB * (i + 1);
				}
			}
		}
		if (N == i) {
			return "";
		}
		String result = "";
		for (i = 0; i < mChar.size(); i++) {
			result += mChar.get(i);
		}
		return result;
	}

	public void init(ArrayList<Character> mChar, int N) {
		for (int i = 0; i < N; i++) {
			mChar.add('B');
		}
	}

	public static void main(String[] args) {
		AB a = new AB();
		System.out.println(a.createString(5, 5));
	}
}
