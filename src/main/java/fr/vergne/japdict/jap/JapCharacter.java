package fr.vergne.japdict.jap;

import java.util.Collections;
import java.util.List;

import fr.vergne.japdict.util.StringUtil;

/**
 * A {@link JapCharacter} wraps a character with a rich set of methods to deal
 * with Japanese characters. In particular, if a Japanese character is a kana,
 * it can ba a hiragana or a katakana (represented through its {@link KanaType}
 * ), and several variants can exist like tenten and maru variants (represented
 * through its {@link KanaVariant}). Various methods are provided to retrieve
 * and modify these characteristics.
 * 
 * @author Matthieu Vergne <matthieu.vergne@gmail.com>
 * 
 */
public class JapCharacter {

	private final char character;

	/**
	 * 
	 * @param character
	 *            the character to consider as a {@link JapCharacter}
	 */
	public JapCharacter(char character) {
		this.character = character;
	}

	/**
	 * 
	 * @return the <code>char</code> corresponding to this {@link JapCharacter}
	 */
	public char toChar() {
		return character;
	}

	/**
	 * 
	 * @param type
	 * @param variant
	 * @return <code>true</code> if the {@link JapCharacter} is a kana of the
	 *         given type and variant, <code>false</code> otherwise
	 */
	public boolean isKana(KanaType type, KanaVariant variant) {
		if (type == KanaType.HIRAGANA) {
			if (variant == KanaVariant.NONE) {
				return HIRAGANAS_CLASSIC.contains(character)
						|| HIRAGANAS_OLD.contains(character);
			} else if (variant == KanaVariant.TENTEN) {
				return StringUtil.split("ゔがぎぐげござじずぜぞだぢづでどばびぶべぼ").contains(
						character);
			} else if (variant == KanaVariant.SMALL) {
				return StringUtil.split("ぁぃぅぇぉゕゖっゃゅょゎ").contains(character);
			} else if (variant == KanaVariant.MARU) {
				return StringUtil.split("ぱぴぷぺぽ").contains(character);
			} else if (variant == null) {
				return isKana(type, KanaVariant.MARU)
						|| isKana(type, KanaVariant.SMALL)
						|| isKana(type, KanaVariant.TENTEN)
						|| isKana(type, KanaVariant.NONE);
			} else {
				throw new RuntimeException("Unmanaged hiragana variant: "
						+ variant);
			}
		} else if (type == KanaType.KATAKANA) {
			if (variant == KanaVariant.NONE) {
				return KATAKANAS_CLASSIC.contains(character)
						|| KATAKANAS_OLD.contains(character);
			} else if (variant == KanaVariant.TENTEN) {
				return StringUtil.split("ガギグゲゴザジズゼゾダヂヅデドバビブベボヴヷヸヹヺ").contains(
						character);
			} else if (variant == KanaVariant.SMALL) {
				return StringUtil.split("ァィゥェォッャュョヮヵヶ").contains(character);
			} else if (variant == KanaVariant.MARU) {
				return StringUtil.split("パピプペポ").contains(character);
			} else if (variant == null) {
				return isKana(type, KanaVariant.MARU)
						|| isKana(type, KanaVariant.SMALL)
						|| isKana(type, KanaVariant.TENTEN)
						|| isKana(type, KanaVariant.NONE);
			} else {
				throw new RuntimeException("Unmanaged katakana variant: "
						+ variant);
			}
		} else if (type == null) {
			return isKana(KanaType.HIRAGANA, variant)
					|| isKana(KanaType.KATAKANA, variant);
		} else {
			throw new RuntimeException("Unmanaged type: " + type);
		}
	}

	/**
	 * 
	 * @param type
	 * @return <code>true</code> if the {@link JapCharacter} is a kana of the
	 *         given type, <code>false</code> otherwise
	 */
	public boolean isKana(KanaType type) {
		return isKana(type, null);
	}

	/**
	 * 
	 * @param variant
	 * @return <code>true</code> if the {@link JapCharacter} is a kana of the
	 *         given variant, <code>false</code> otherwise
	 */
	public boolean isKana(KanaVariant variant) {
		return isKana(null, variant);
	}

	/**
	 * 
	 * @return <code>true</code> if the {@link JapCharacter} is a kana,
	 *         <code>false</code> otherwise
	 */
	public boolean isKana() {
		return isKana((KanaType) null);
	}

	/**
	 * 
	 * @return <code>true</code> if the {@link JapCharacter} is a kanji,
	 *         <code>false</code> otherwise
	 */
	public boolean isKanji() {
		return character >= KANJI_MIN && character <= KANJI_MAX
				|| character >= KANJI_RARE_MIN && character <= KANJI_RARE_MAX;
	}

	/**
	 * 
	 * @return the {@link KanaVariant} corresponding to this
	 *         {@link JapCharacter} if it is a kana, <code>null</code> otherwise
	 */
	public KanaVariant getKanaVariant() {
		for (KanaVariant variant : KanaVariant.values()) {
			if (isKana(variant)) {
				return variant;
			} else {
				// not found yet
			}
		}
		return null;
	}

	/**
	 * 
	 * @param newVariant
	 * @return a new {@link JapCharacter} with the corresponding variant,
	 *         <code>null</code> if there is no such variant for this character
	 */
	public JapCharacter toKanaVariant(KanaVariant newVariant) {
		if (newVariant == null) {
			throw new NullPointerException("No variant specified");
		} else if (newVariant == KanaVariant.NONE) {
			if (isKana(KanaVariant.NONE)) {
				return this;
			} else {
				switch (character) {
				case 'ゔ':
					return new JapCharacter('う');
				case 'が':
					return new JapCharacter('か');
				case 'ぎ':
					return new JapCharacter('き');
				case 'ぐ':
					return new JapCharacter('く');
				case 'げ':
					return new JapCharacter('け');
				case 'ご':
					return new JapCharacter('こ');
				case 'ざ':
					return new JapCharacter('さ');
				case 'じ':
					return new JapCharacter('し');
				case 'ず':
					return new JapCharacter('す');
				case 'ぜ':
					return new JapCharacter('せ');
				case 'ぞ':
					return new JapCharacter('そ');
				case 'だ':
					return new JapCharacter('た');
				case 'ぢ':
					return new JapCharacter('ち');
				case 'づ':
					return new JapCharacter('つ');
				case 'で':
					return new JapCharacter('て');
				case 'ど':
					return new JapCharacter('と');
				case 'ば':
					return new JapCharacter('は');
				case 'び':
					return new JapCharacter('ひ');
				case 'ぶ':
					return new JapCharacter('ふ');
				case 'べ':
					return new JapCharacter('へ');
				case 'ぼ':
					return new JapCharacter('ほ');
				case 'ぱ':
					return new JapCharacter('は');
				case 'ぴ':
					return new JapCharacter('ひ');
				case 'ぷ':
					return new JapCharacter('ふ');
				case 'ぺ':
					return new JapCharacter('へ');
				case 'ぽ':
					return new JapCharacter('ほ');
				case 'ぁ':
					return new JapCharacter('あ');
				case 'ぃ':
					return new JapCharacter('い');
				case 'ぅ':
					return new JapCharacter('う');
				case 'ぇ':
					return new JapCharacter('え');
				case 'ぉ':
					return new JapCharacter('お');
				case 'ゕ':
					return new JapCharacter('か');
				case 'ゖ':
					return new JapCharacter('け');
				case 'っ':
					return new JapCharacter('つ');
				case 'ゃ':
					return new JapCharacter('や');
				case 'ゅ':
					return new JapCharacter('ゆ');
				case 'ょ':
					return new JapCharacter('よ');
				case 'ゎ':
					return new JapCharacter('わ');
				case 'ヴ':
					return new JapCharacter('ウ');
				case 'ガ':
					return new JapCharacter('カ');
				case 'ギ':
					return new JapCharacter('キ');
				case 'グ':
					return new JapCharacter('ク');
				case 'ゲ':
					return new JapCharacter('ケ');
				case 'ゴ':
					return new JapCharacter('コ');
				case 'ザ':
					return new JapCharacter('サ');
				case 'ジ':
					return new JapCharacter('シ');
				case 'ズ':
					return new JapCharacter('ス');
				case 'ゼ':
					return new JapCharacter('セ');
				case 'ゾ':
					return new JapCharacter('ソ');
				case 'ダ':
					return new JapCharacter('タ');
				case 'ヂ':
					return new JapCharacter('チ');
				case 'ヅ':
					return new JapCharacter('ツ');
				case 'デ':
					return new JapCharacter('テ');
				case 'ド':
					return new JapCharacter('ト');
				case 'バ':
					return new JapCharacter('ハ');
				case 'ビ':
					return new JapCharacter('ヒ');
				case 'ブ':
					return new JapCharacter('フ');
				case 'ベ':
					return new JapCharacter('ヘ');
				case 'ボ':
					return new JapCharacter('ホ');
				case 'ヷ':
					return new JapCharacter('ワ');
				case 'ヺ':
					return new JapCharacter('ヲ');
				case 'ヸ':
					return new JapCharacter('ヰ');
				case 'ヹ':
					return new JapCharacter('ヱ');
				case 'パ':
					return new JapCharacter('ハ');
				case 'ピ':
					return new JapCharacter('ヒ');
				case 'プ':
					return new JapCharacter('フ');
				case 'ペ':
					return new JapCharacter('ヘ');
				case 'ポ':
					return new JapCharacter('ホ');
				case 'ァ':
					return new JapCharacter('ア');
				case 'ィ':
					return new JapCharacter('イ');
				case 'ゥ':
					return new JapCharacter('ウ');
				case 'ェ':
					return new JapCharacter('エ');
				case 'ォ':
					return new JapCharacter('オ');
				case 'ヵ':
					return new JapCharacter('カ');
				case 'ヶ':
					return new JapCharacter('ケ');
				case 'ッ':
					return new JapCharacter('ツ');
				case 'ャ':
					return new JapCharacter('ヤ');
				case 'ュ':
					return new JapCharacter('ユ');
				case 'ョ':
					return new JapCharacter('ヨ');
				case 'ヮ':
					return new JapCharacter('ワ');
				default:
					return null;
				}
			}
		} else if (newVariant == KanaVariant.TENTEN) {
			if (isKana(KanaVariant.TENTEN)) {
				return this;
			} else if (!isKana(KanaVariant.NONE)) {
				JapCharacter base = toKanaVariant(KanaVariant.NONE);
				if (base == null) {
					return null;
				} else {
					return base.toKanaVariant(KanaVariant.TENTEN);
				}
			} else {
				switch (character) {
				case 'う':
					return new JapCharacter('ゔ');
				case 'か':
					return new JapCharacter('が');
				case 'き':
					return new JapCharacter('ぎ');
				case 'く':
					return new JapCharacter('ぐ');
				case 'け':
					return new JapCharacter('げ');
				case 'こ':
					return new JapCharacter('ご');
				case 'さ':
					return new JapCharacter('ざ');
				case 'し':
					return new JapCharacter('じ');
				case 'す':
					return new JapCharacter('ず');
				case 'せ':
					return new JapCharacter('ぜ');
				case 'そ':
					return new JapCharacter('ぞ');
				case 'た':
					return new JapCharacter('だ');
				case 'ち':
					return new JapCharacter('ぢ');
				case 'つ':
					return new JapCharacter('づ');
				case 'て':
					return new JapCharacter('で');
				case 'と':
					return new JapCharacter('ど');
				case 'は':
					return new JapCharacter('ば');
				case 'ひ':
					return new JapCharacter('び');
				case 'ふ':
					return new JapCharacter('ぶ');
				case 'へ':
					return new JapCharacter('べ');
				case 'ほ':
					return new JapCharacter('ぼ');
				case 'ウ':
					return new JapCharacter('ヴ');
				case 'カ':
					return new JapCharacter('ガ');
				case 'キ':
					return new JapCharacter('ギ');
				case 'ク':
					return new JapCharacter('グ');
				case 'ケ':
					return new JapCharacter('ゲ');
				case 'コ':
					return new JapCharacter('ゴ');
				case 'サ':
					return new JapCharacter('ザ');
				case 'シ':
					return new JapCharacter('ジ');
				case 'ス':
					return new JapCharacter('ズ');
				case 'セ':
					return new JapCharacter('ゼ');
				case 'ソ':
					return new JapCharacter('ゾ');
				case 'タ':
					return new JapCharacter('ダ');
				case 'チ':
					return new JapCharacter('ヂ');
				case 'ツ':
					return new JapCharacter('ヅ');
				case 'テ':
					return new JapCharacter('デ');
				case 'ト':
					return new JapCharacter('ド');
				case 'ハ':
					return new JapCharacter('バ');
				case 'ヒ':
					return new JapCharacter('ビ');
				case 'フ':
					return new JapCharacter('ブ');
				case 'ヘ':
					return new JapCharacter('ベ');
				case 'ホ':
					return new JapCharacter('ボ');
				case 'ワ':
					return new JapCharacter('ヷ');
				case 'ヲ':
					return new JapCharacter('ヺ');
				case 'ヰ':
					return new JapCharacter('ヸ');
				case 'ヱ':
					return new JapCharacter('ヹ');
				default:
					return null;
				}
			}
		} else if (newVariant == KanaVariant.MARU) {
			if (isKana(KanaVariant.MARU)) {
				return this;
			} else if (!isKana(KanaVariant.NONE)) {
				JapCharacter base = toKanaVariant(KanaVariant.NONE);
				if (base == null) {
					return null;
				} else {
					return base.toKanaVariant(KanaVariant.MARU);
				}
			} else {
				switch (character) {
				case 'は':
					return new JapCharacter('ぱ');
				case 'ひ':
					return new JapCharacter('ぴ');
				case 'ふ':
					return new JapCharacter('ぷ');
				case 'へ':
					return new JapCharacter('ぺ');
				case 'ほ':
					return new JapCharacter('ぽ');
				case 'ハ':
					return new JapCharacter('パ');
				case 'ヒ':
					return new JapCharacter('ピ');
				case 'フ':
					return new JapCharacter('プ');
				case 'ヘ':
					return new JapCharacter('ペ');
				case 'ホ':
					return new JapCharacter('ポ');
				default:
					return null;
				}
			}
		} else if (newVariant == KanaVariant.SMALL) {
			if (isKana(KanaVariant.SMALL)) {
				return this;
			} else if (!isKana(KanaVariant.NONE)) {
				JapCharacter base = toKanaVariant(KanaVariant.NONE);
				if (base == null) {
					return null;
				} else {
					return base.toKanaVariant(KanaVariant.SMALL);
				}
			} else {
				switch (character) {
				case 'あ':
					return new JapCharacter('ぁ');
				case 'い':
					return new JapCharacter('ぃ');
				case 'う':
					return new JapCharacter('ぅ');
				case 'え':
					return new JapCharacter('ぇ');
				case 'お':
					return new JapCharacter('ぉ');
				case 'か':
					return new JapCharacter('ゕ');
				case 'け':
					return new JapCharacter('ゖ');
				case 'つ':
					return new JapCharacter('っ');
				case 'や':
					return new JapCharacter('ゃ');
				case 'ゆ':
					return new JapCharacter('ゅ');
				case 'よ':
					return new JapCharacter('ょ');
				case 'わ':
					return new JapCharacter('ゎ');
				case 'ア':
					return new JapCharacter('ァ');
				case 'イ':
					return new JapCharacter('ィ');
				case 'ウ':
					return new JapCharacter('ゥ');
				case 'エ':
					return new JapCharacter('ェ');
				case 'オ':
					return new JapCharacter('ォ');
				case 'カ':
					return new JapCharacter('ヵ');
				case 'ケ':
					return new JapCharacter('ヶ');
				case 'ツ':
					return new JapCharacter('ッ');
				case 'ヤ':
					return new JapCharacter('ャ');
				case 'ユ':
					return new JapCharacter('ュ');
				case 'ヨ':
					return new JapCharacter('ョ');
				case 'ワ':
					return new JapCharacter('ヮ');
				default:
					return null;
				}
			}
		} else {
			throw new RuntimeException("Unmanaged variant: " + newVariant);
		}
	}

	/**
	 * 
	 * @return the {@link KanaType} corresponding to this character if it is a
	 *         kana, <code>null</code> otherwise
	 */
	public KanaType getKanaType() {
		for (KanaType type : KanaType.values()) {
			if (isKana(type)) {
				return type;
			} else {
				// not found yet
			}
		}
		return null;
	}

	/**
	 * 
	 * @param newType
	 * @return a new {@link JapCharacter} with the corresponding type,
	 *         <code>null</code> if there is no such type for this character
	 */
	public JapCharacter toKanaType(KanaType newType) {
		KanaVariant oldVariant = getKanaVariant();
		if (oldVariant == null) {
			return null;// not a kana
		} else {
			char oldBase = toKanaVariant(KanaVariant.NONE).toChar();

			List<Character> listFrom;
			if (getKanaType() == KanaType.HIRAGANA) {
				if (HIRAGANAS_OLD.contains(oldBase)) {
					listFrom = HIRAGANAS_OLD;
				} else {
					listFrom = HIRAGANAS_CLASSIC;
				}
			} else if (getKanaType() == KanaType.KATAKANA) {
				if (KATAKANAS_OLD.contains(oldBase)) {
					listFrom = KATAKANAS_OLD;
				} else {
					listFrom = KATAKANAS_CLASSIC;
				}
			} else {
				throw new RuntimeException("No " + newType + " for "
						+ character);
			}

			List<Character> listTo;
			if (newType == KanaType.HIRAGANA) {
				if (HIRAGANAS_OLD.contains(oldBase)
						|| KATAKANAS_OLD.contains(oldBase)) {
					listTo = HIRAGANAS_OLD;
				} else {
					listTo = HIRAGANAS_CLASSIC;
				}
			} else {
				if (HIRAGANAS_OLD.contains(oldBase)
						|| KATAKANAS_OLD.contains(oldBase)) {
					listTo = KATAKANAS_OLD;
				} else {
					listTo = KATAKANAS_CLASSIC;
				}
			}

			int index = listFrom.indexOf(oldBase);
			Character newBase = listTo.get(index);
			JapCharacter newCharacter = new JapCharacter(newBase)
					.toKanaVariant(oldVariant);
			return newCharacter;
		}
	}

	/**
	 * Two {@link JapCharacter} are equals when representing the same character.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj instanceof JapCharacter) {
			JapCharacter c = (JapCharacter) obj;
			return character == c.character;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return character;
	}

	@Override
	public String toString() {
		return "" + character;
	}

	/************ STATIC ************/

	// private static final char HIRAGANA_MIN = '\u3041';
	// private static final char HIRAGANA_MAX = '\u3096';
	// private static final char KATAKANA_MIN = '\u30A1';
	// private static final char KATAKANA_MAX = '\u30FA';
	// private static final char KATAKANA_AINU_MIN = '\u31F0';
	// private static final char KATAKANA_AINU_MAX = '\u31FF';
	private static final char KANJI_RARE_MIN = '\u3400';
	private static final char KANJI_RARE_MAX = '\u4DB5';
	private static final char KANJI_MIN = '\u4E01';
	private static final char KANJI_MAX = '\u9FAF';
	// private static final char KATAKANA_HALF_MIN = '\uFF65';
	// private static final char KATAKANA_HALF_MAX = '\uFF9F';
	private static final List<Character> HIRAGANAS_CLASSIC = Collections
			.unmodifiableList(StringUtil
					.split("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん"));
	private static final List<Character> HIRAGANAS_OLD = Collections
			.unmodifiableList(StringUtil.split("ゐゑ"));
	private static final List<Character> KATAKANAS_CLASSIC = Collections
			.unmodifiableList(StringUtil
					.split("アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲン"));
	private static final List<Character> KATAKANAS_OLD = Collections
			.unmodifiableList(StringUtil.split("ヰヱ"));
}
