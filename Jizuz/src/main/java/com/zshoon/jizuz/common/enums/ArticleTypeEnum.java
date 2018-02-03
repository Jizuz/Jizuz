package com.zshoon.jizuz.common.enums;

/**
 * 〈文章类型〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public enum ArticleTypeEnum {

	JAVA("1", "java"), PY("2", "python"), PHP("3", "php"), WEBGL("4", "WebGL"), FRONT("5", "前端"), //
	PROBLEM("6", "问题"), SHOOT("7", "摄影技巧"), PS("8", "PhotoShop"), AE("9", "AfterEffects"), //
	PR("10", "Premiere"), MAX("11", "3Ds Max"), SPORTS("12", "运动"), THINK("13", "随想");

	/**
	 * code:code
	 */
	private String code;

	/**
	 * desc:description
	 */
	private String desc;

	/**
	 * @param code
	 * @param desc
	 */
	ArticleTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 〈按照字符获取指定的枚举类型〉
	 *
	 * @param v
	 *            String
	 * @return ArticleTypeEnum
	 * @author 17081480
	 * @since v1.0.0
	 */
	public ArticleTypeEnum fromCode(String v) {
		for (ArticleTypeEnum c : ArticleTypeEnum.values()) {
			if (c.code.equals(v)) {
				return c;
			}
		}
		return null;
	}
}
