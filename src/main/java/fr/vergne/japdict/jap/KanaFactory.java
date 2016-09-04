package fr.vergne.japdict.jap;

import java.util.List;

public class KanaFactory {

	/**
	 * 
	 * @param character
	 *            the {@link JapCharacter} to start from
	 * @param variant
	 *            the {@link KanaVariant} to apply
	 * @return a new {@link JapCharacter} with the corresponding
	 *         {@link KanaVariant}, <code>null</code> if no such
	 *         {@link JapCharacter} exists
	 */
	public JapCharacter transform(JapCharacter character, KanaVariant variant) {
		if (variant == null) {
			throw new NullPointerException("No variant specified");
		} else if (variant == KanaVariant.NONE) {
			if (character.isKana(KanaVariant.NONE)) {
				return character;
			} else {
				switch (character.toChar()) {
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
		} else if (variant == KanaVariant.TENTEN) {
			if (character.isKana(KanaVariant.TENTEN)) {
				return character;
			} else if (!character.isKana(KanaVariant.NONE)) {
				JapCharacter base = transform(character, KanaVariant.NONE);
				if (base == null) {
					return null;
				} else {
					return transform(base, KanaVariant.TENTEN);
				}
			} else {
				switch (character.toChar()) {
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
		} else if (variant == KanaVariant.MARU) {
			if (character.isKana(KanaVariant.MARU)) {
				return character;
			} else if (!character.isKana(KanaVariant.NONE)) {
				JapCharacter base = transform(character, KanaVariant.NONE);
				if (base == null) {
					return null;
				} else {
					return transform(base, KanaVariant.MARU);
				}
			} else {
				switch (character.toChar()) {
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
		} else if (variant == KanaVariant.SMALL) {
			if (character.isKana(KanaVariant.SMALL)) {
				return character;
			} else if (!character.isKana(KanaVariant.NONE)) {
				JapCharacter base = transform(character, KanaVariant.NONE);
				if (base == null) {
					return null;
				} else {
					return transform(base, KanaVariant.SMALL);
				}
			} else {
				switch (character.toChar()) {
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
			throw new RuntimeException("Unmanaged variant: " + variant);
		}
	}

	/**
	 * 
	 * @param character
	 *            the {@link JapCharacter} to start from
	 * @param newType
	 *            the {@link KanaType} to apply
	 * @return a new {@link JapCharacter} with the corresponding
	 *         {@link KanaType}, <code>null</code> if no such
	 *         {@link JapCharacter} exists
	 */
	public JapCharacter transform(JapCharacter character, KanaType newType) {
		KanaVariant oldVariant = character.getKanaVariant();
		if (oldVariant == null) {
			return null;// not a kana
		} else {
			char oldBase = transform(character, KanaVariant.NONE).toChar();

			List<Character> listFrom;
			if (character.getKanaType() == KanaType.HIRAGANA) {
				if (JapUnicode.HIRAGANAS_OLD.contains(oldBase)) {
					listFrom = JapUnicode.HIRAGANAS_OLD;
				} else {
					listFrom = JapUnicode.HIRAGANAS_CLASSIC;
				}
			} else if (character.getKanaType() == KanaType.KATAKANA) {
				if (JapUnicode.KATAKANAS_OLD.contains(oldBase)) {
					listFrom = JapUnicode.KATAKANAS_OLD;
				} else {
					listFrom = JapUnicode.KATAKANAS_CLASSIC;
				}
			} else {
				throw new RuntimeException("No " + newType + " for "
						+ character);
			}

			List<Character> listTo;
			if (newType == KanaType.HIRAGANA) {
				if (JapUnicode.HIRAGANAS_OLD.contains(oldBase)
						|| JapUnicode.KATAKANAS_OLD.contains(oldBase)) {
					listTo = JapUnicode.HIRAGANAS_OLD;
				} else {
					listTo = JapUnicode.HIRAGANAS_CLASSIC;
				}
			} else {
				if (JapUnicode.HIRAGANAS_OLD.contains(oldBase)
						|| JapUnicode.KATAKANAS_OLD.contains(oldBase)) {
					listTo = JapUnicode.KATAKANAS_OLD;
				} else {
					listTo = JapUnicode.KATAKANAS_CLASSIC;
				}
			}

			int index = listFrom.indexOf(oldBase);
			Character newBase = listTo.get(index);
			JapCharacter newCharacter = transform(new JapCharacter(newBase),
					oldVariant);
			return newCharacter;
		}
	}

	/**
	 * 
	 * @param character
	 *            the {@link JapCharacter} to start from
	 * @param type
	 *            the {@link KanaType} to apply
	 * @param variant
	 *            the {@link KanaVariant} to apply
	 * @return a new {@link JapCharacter} with the corresponding
	 *         {@link KanaType} and {@link KanaVariant}, <code>null</code> if
	 *         there is no such {@link JapCharacter} exists
	 */
	public JapCharacter transform(JapCharacter character, KanaType type,
			KanaVariant variant) {
		JapCharacter base = transform(character, KanaVariant.NONE);
		if (base == null) {
			return null;
		} else {
			JapCharacter typed = transform(base, type);
			if (typed == null) {
				return null;
			} else {
				return transform(typed, variant);
			}
		}
	}
}
