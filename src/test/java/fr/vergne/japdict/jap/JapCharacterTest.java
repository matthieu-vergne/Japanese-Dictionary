package fr.vergne.japdict.jap;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.vergne.japdict.util.StringUtil;

public class JapCharacterTest {

	private static String display(Character character) {
		return character + " (\\u" + Integer.toHexString(character) + ")";
	}
	
	@Test
	public void testIsKanaTypeAndVariantCorrectForClassicHiraganas() {
		for (Character character : StringUtil
				.split("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん")) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantCorrectForOldHiraganas() {
		for (Character character : StringUtil.split("ゐゑ")) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantCorrectForTentenHiraganas() {
		for (Character character : StringUtil.split("ゔがぎぐげござじずぜぞだぢづでどばびぶべぼ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantCorrectForMaruHiraganas() {
		for (Character character : StringUtil.split("ぱぴぷぺぽ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantCorrectForSmallHiraganas() {
		for (Character character : StringUtil.split("ぁぃぅぇぉゕゖっゃゅょゎ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantCorrectForClassicKatakanas() {
		for (Character character : StringUtil
				.split("アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲン")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantCorrectForOldKatakanas() {
		for (Character character : StringUtil.split("ヰヱ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantCorrectForTentenKatakanas() {
		for (Character character : StringUtil
				.split("ヴガギグゲゴザジズゼゾダヂヅデドバビブベボヷヺヸヹ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantCorrectForMaruKatakanas() {
		for (Character character : StringUtil.split("パピプペポ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantCorrectForSmallKatakanas() {
		for (Character character : StringUtil.split("ァィゥェォヵヶッャュョヮ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.MARU));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.HIRAGANA, KanaVariant.SMALL));

			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.NONE));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.TENTEN));
			assertFalse(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.MARU));
			assertTrue(message, new JapCharacter(character).isKana(
					KanaType.KATAKANA, KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaTypeAndVariantFalseForAllNonKanas() {
		for (int code = '\u0000'; code <= '\uFFFF'; code++) {
			if (code >= JapUnicode.HIRAGANA_MIN
					&& code <= JapUnicode.HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (code >= JapUnicode.KATAKANA_MIN
					&& code <= JapUnicode.KATAKANA_MAX) {
				// ignore katakanas
			} else {
				String message = display((char) code) + " wrongly recognised";
				assertFalse(message, new JapCharacter((char) code).isKana(
						KanaType.HIRAGANA, KanaVariant.NONE));
				assertFalse(message, new JapCharacter((char) code).isKana(
						KanaType.HIRAGANA, KanaVariant.TENTEN));
				assertFalse(message, new JapCharacter((char) code).isKana(
						KanaType.HIRAGANA, KanaVariant.MARU));
				assertFalse(message, new JapCharacter((char) code).isKana(
						KanaType.HIRAGANA, KanaVariant.SMALL));

				assertFalse(message, new JapCharacter((char) code).isKana(
						KanaType.KATAKANA, KanaVariant.NONE));
				assertFalse(message, new JapCharacter((char) code).isKana(
						KanaType.KATAKANA, KanaVariant.TENTEN));
				assertFalse(message, new JapCharacter((char) code).isKana(
						KanaType.KATAKANA, KanaVariant.MARU));
				assertFalse(message, new JapCharacter((char) code).isKana(
						KanaType.KATAKANA, KanaVariant.SMALL));
			}
		}
	}

	@Test
	public void testIsKanaTypeCorrectForAllHiraganas() {
		for (char character = JapUnicode.HIRAGANA_MIN; character <= JapUnicode.HIRAGANA_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message,
					new JapCharacter(character).isKana(KanaType.HIRAGANA));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaType.KATAKANA));
		}
	}

	@Test
	public void testIsKanaTypeCorrectForAllKatakanas() {
		for (char character = JapUnicode.KATAKANA_MIN; character <= JapUnicode.KATAKANA_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message,
					new JapCharacter(character).isKana(KanaType.HIRAGANA));
			assertTrue(message,
					new JapCharacter(character).isKana(KanaType.KATAKANA));
		}
	}

	@Test
	public void testIsKanaTypeFalseForAllNonKanas() {
		for (int character = '\u0000'; character <= '\uFFFF'; character++) {
			if (character >= JapUnicode.HIRAGANA_MIN
					&& character <= JapUnicode.HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (character >= JapUnicode.KATAKANA_MIN
					&& character <= JapUnicode.KATAKANA_MAX) {
				// ignore katakanas
			} else {
				String message = display((char) character)
						+ " wrongly recognised";
				assertFalse(message,
						new JapCharacter((char) character)
								.isKana(KanaType.HIRAGANA));
				assertFalse(message,
						new JapCharacter((char) character)
								.isKana(KanaType.KATAKANA));
			}
		}
	}

	@Test
	public void testIsKanaVariantCorrectForAllClassics() {
		for (char character : StringUtil
				.split("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをんアイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲン")) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message,
					new JapCharacter(character).isKana(KanaVariant.NONE));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.TENTEN));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.MARU));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaVariantCorrectForAllOlds() {
		for (char character : StringUtil.split("ゐゑヰヱ")) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message,
					new JapCharacter(character).isKana(KanaVariant.NONE));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.TENTEN));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.MARU));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaVariantCorrectForAllTentens() {
		for (char character : StringUtil
				.split("ゔがぎぐげござじずぜぞだぢづでどばびぶべぼヴガギグゲゴザジズゼゾダヂヅデドバビブベボヷヺヸヹ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.NONE));
			assertTrue(message,
					new JapCharacter(character).isKana(KanaVariant.TENTEN));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.MARU));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaVariantCorrectForAllMarus() {
		for (char character : StringUtil.split("ぱぴぷぺぽパピプペポ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.NONE));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.TENTEN));
			assertTrue(message,
					new JapCharacter(character).isKana(KanaVariant.MARU));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaVariantCorrectForAllSmalls() {
		for (char character : StringUtil.split("ぁぃぅぇぉゕゖっゃゅょゎァィゥェォヵヶッャュョヮ")) {
			String message = display(character) + " wrongly recognised";
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.NONE));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.TENTEN));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaVariant.MARU));
			assertTrue(message,
					new JapCharacter(character).isKana(KanaVariant.SMALL));
		}
	}

	@Test
	public void testIsKanaVariantFalseForAllNonKanas() {
		for (int character = '\u0000'; character <= '\uFFFF'; character++) {
			if (character >= JapUnicode.HIRAGANA_MIN
					&& character <= JapUnicode.HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (character >= JapUnicode.KATAKANA_MIN
					&& character <= JapUnicode.KATAKANA_MAX) {
				// ignore katakanas
			} else {
				String message = display((char) character)
						+ " wrongly recognised";
				assertFalse(message,
						new JapCharacter((char) character)
								.isKana(KanaVariant.NONE));
				assertFalse(message,
						new JapCharacter((char) character)
								.isKana(KanaVariant.TENTEN));
				assertFalse(message,
						new JapCharacter((char) character)
								.isKana(KanaVariant.MARU));
				assertFalse(message,
						new JapCharacter((char) character)
								.isKana(KanaVariant.SMALL));
			}
		}
	}

	@Test
	public void testIsKanaTrueForAllKanas() {
		for (char character = JapUnicode.HIRAGANA_MIN; character <= JapUnicode.HIRAGANA_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKana());
		}
		for (char character = JapUnicode.KATAKANA_MIN; character <= JapUnicode.KATAKANA_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKana());
		}
	}

	@Test
	public void testIsKanaFalseForAllNonKanas() {
		for (int character = '\u0000'; character <= '\uFFFF'; character++) {
			if (character >= JapUnicode.HIRAGANA_MIN
					&& character <= JapUnicode.HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (character >= JapUnicode.KATAKANA_MIN
					&& character <= JapUnicode.KATAKANA_MAX) {
				// ignore katakanas
			} else {
				String message = display((char) character)
						+ " wrongly recognised";
				assertFalse(message,
						new JapCharacter((char) character).isKana());
			}
		}
	}

	@Test
	public void testIsKanjiTrueForAllKanjis() {
		for (char character = JapUnicode.KANJI_MIN; character <= JapUnicode.KANJI_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKanji());
		}
		for (char character = JapUnicode.KANJI_RARE_MIN; character <= JapUnicode.KANJI_RARE_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKanji());
		}
	}

	@Test
	public void testIsKanjiFalseForAllNonKanjis() {
		for (int character = '\u0000'; character <= '\uFFFF'; character++) {
			if (character >= JapUnicode.KANJI_MIN
					&& character <= JapUnicode.KANJI_MAX) {
				// ignore usual kanjis
			} else if (character >= JapUnicode.KANJI_RARE_MIN
					&& character <= JapUnicode.KANJI_RARE_MAX) {
				// ignore rare kanjis
			} else {
				String message = display((char) character)
						+ " wrongly recognised";
				assertFalse(message,
						new JapCharacter((char) character).isKanji());
			}
		}
	}

	@Test
	public void testGetCorrectKanaType() {
		for (int character = '\u0000'; character <= '\uFFFF'; character++) {
			KanaType type = new JapCharacter((char) character).getKanaType();
			String message = display((char) character) + " recognised as "
					+ type;
			if (character >= JapUnicode.HIRAGANA_MIN
					&& character <= JapUnicode.HIRAGANA_MAX) {
				assertEquals(message, KanaType.HIRAGANA, type);
			} else if (character >= JapUnicode.KATAKANA_MIN
					&& character <= JapUnicode.KATAKANA_MAX) {
				assertEquals(message, KanaType.KATAKANA, type);
			} else {
				assertEquals(message, null, type);
			}
		}
	}

	@Test
	public void testGetCorrectKanaVariant() {
		for (int character = '\u0000'; character <= '\uFFFF'; character++) {
			KanaVariant variant = new JapCharacter((char) character)
					.getKanaVariant();
			String message = display((char) character) + " recognised as "
					+ variant;
			if (character >= JapUnicode.HIRAGANA_MIN
					&& character <= JapUnicode.HIRAGANA_MAX) {
				if ("ぱぴぷぺぽ".contains("" + (char) character)) {
					assertEquals(message, KanaVariant.MARU, variant);
				} else if ("ぁぃぅぇぉゕゖっゃゅょゎ".contains("" + (char) character)) {
					assertEquals(message, KanaVariant.SMALL, variant);
				} else if ("ゔがぎぐげござじずぜぞだぢづでどばびぶべぼ".contains(""
						+ (char) character)) {
					assertEquals(message, KanaVariant.TENTEN, variant);
				} else {
					assertEquals(message, KanaVariant.NONE, variant);
				}
			} else if (character >= JapUnicode.KATAKANA_MIN
					&& character <= JapUnicode.KATAKANA_MAX) {
				if ("パピプペポ".contains("" + (char) character)) {
					assertEquals(message, KanaVariant.MARU, variant);
				} else if ("ァィゥェォヵヶッャュョヮ".contains("" + (char) character)) {
					assertEquals(message, KanaVariant.SMALL, variant);
				} else if ("ヴガギグゲゴザジズゼゾダヂヅデドバビブベボヷヺヸヹ".contains(""
						+ (char) character)) {
					assertEquals(message, KanaVariant.TENTEN, variant);
				} else {
					assertEquals(message, KanaVariant.NONE, variant);
				}
			} else {
				assertEquals(message, null, variant);
			}
		}
	}
}
