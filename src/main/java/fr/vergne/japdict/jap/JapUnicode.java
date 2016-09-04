package fr.vergne.japdict.jap;

import java.util.Collections;
import java.util.List;

import fr.vergne.japdict.util.StringUtil;

public class JapUnicode {

	public static final char HIRAGANA_MIN = '\u3041';
	public static final char HIRAGANA_MAX = '\u3096';
	public static final char KATAKANA_MIN = '\u30A1';
	public static final char KATAKANA_MAX = '\u30FA';
	public static final char KATAKANA_AINU_MIN = '\u31F0';
	public static final char KATAKANA_AINU_MAX = '\u31FF';
	public static final char KANJI_RARE_MIN = '\u3400';
	public static final char KANJI_RARE_MAX = '\u4DB5';
	public static final char KANJI_MIN = '\u4E01';
	public static final char KANJI_MAX = '\u9FAF';
	public static final char KATAKANA_HALF_MIN = '\uFF65';
	public static final char KATAKANA_HALF_MAX = '\uFF9F';

	public static final List<Character> HIRAGANAS_CLASSIC = Collections
			.unmodifiableList(StringUtil
					.split("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん"));
	public static final List<Character> HIRAGANAS_OLD = Collections
			.unmodifiableList(StringUtil.split("ゐゑ"));
	public static final List<Character> KATAKANAS_CLASSIC = Collections
			.unmodifiableList(StringUtil
					.split("アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲン"));
	public static final List<Character> KATAKANAS_OLD = Collections
			.unmodifiableList(StringUtil.split("ヰヱ"));
}
