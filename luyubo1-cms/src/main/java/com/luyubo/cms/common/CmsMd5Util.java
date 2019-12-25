package com.luyubo.cms.common;

import com.bawei.commons.utils.Md5Util;

public class CmsMd5Util {
	public static String string2MD5(String str) {
		return Md5Util.string2MD5(str+"_cmsAdmin");
	}
}
