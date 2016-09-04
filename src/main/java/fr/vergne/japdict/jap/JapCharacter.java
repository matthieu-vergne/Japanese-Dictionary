package fr.vergne.japdict.jap;

import fr.vergne.japdict.util.StringUtil;

/**
 * A {@link JapCharacter} wraps a character with a rich set of methods to deal
 * with Japanese characters. In particular, if a Japanese character is a kana,
 * it can be a hiragana or a katakana (represented through its {@link KanaType}
 * ), and several variants can exist like tenten and maru variants (represented
 * through its {@link KanaVariant}). Various methods are provided to retrieve
 * these characteristics.
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
				return JapUnicode.HIRAGANAS_CLASSIC.contains(character)
						|| JapUnicode.HIRAGANAS_OLD.contains(character);
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
				return JapUnicode.KATAKANAS_CLASSIC.contains(character)
						|| JapUnicode.KATAKANAS_OLD.contains(character);
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
		return character >= JapUnicode.KANJI_MIN
				&& character <= JapUnicode.KANJI_MAX
				|| character >= JapUnicode.KANJI_RARE_MIN
				&& character <= JapUnicode.KANJI_RARE_MAX;
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
	 * Two {@link JapCharacter} are equals when wrapping the same character.
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

	/**
	 * The hashcode of a {@link JapCharacter} is the character it wraps.
	 */
	@Override
	public int hashCode() {
		return character;
	}

	/**
	 * The string representation of a {@link JapCharacter} is the character it wraps.
	 */
	@Override
	public String toString() {
		return "" + character;
	}
}
