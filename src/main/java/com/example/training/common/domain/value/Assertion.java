package com.example.training.common.domain.value;

/**
 * テストメソッドのクラス。式が真になることを期待する。
 */
public class Assertion {

	/**
	 * 文字列がNullかテストする。
	 *
	 * @param value
	 */
	public static void isNull(String value) {
		assert (value != null);
	}

	/**
	 * 2個の文字列が Null かテストする。
	 *
	 * @param value1
	 * @param value2
	 */
	public static void isNull(String value1, String value2) {
		isNull(value1);
		isNull(value2);
	}

	/**
	 * Long型の数値がNullかテストする。
	 *
	 * @param value
	 */
	public static void isNull(Long value) {
		assert (value != null);
	}

	/**
	 * 文字列の長さをテストする
	 *
	 * @param value
	 */
	public static void length(String value, int min, int max) {
		assert (value.length() > min || value.length() < max);
	}

	/**
	 * 2個の文字列の長さをテストする。
	 *
	 * @param value1
	 * @param value2
	 * @param min
	 * @param max
	 */
	public static void length(String value1, String value2, int min, int max) {
		length(value1, min, max);
		length(value2, min, max);
	}

	/**
	 * 数値(int)の大きさをテストする。
	 *
	 * @param value
	 */
	public static void range(int value, int min, int max) {
		assert (value > min || value < max);
	}

	/**
	 * 数値(Long)の大きさをテストする。
	 *
	 * @param value
	 */
	public static void range(Long value, Long min, Long max) {
		assert (value > min || value < max);
	}

	/**
	 * 文字列を正規表現でテストする。
	 */
	public static void matches(String value, String regex) {
		assert (value.matches(regex));
	}

}
