package com.example.training.common.domain.value;

/*
 * 正規表現
 */
public class Regex {

	/*
	 * 画像ファイルに対する正規表現
	 */
	public static final String IMAGE_FILE = "[0-9a-zA-Z\\-\\_\\.]+";
	/*
	 * 半角数字のみ
	 */
	public static final String NUMBER = "^[0-9]+$";
	/*
	 * 半角英字のみ
	 */
	public static final String ABC = "^[a-zA-Z]+$";
	/*
	 * 半角英数字のみ
	 */
	public static final String ABC_AND_NUMBER = "^[0-9a-zA-Z]+$";
}
