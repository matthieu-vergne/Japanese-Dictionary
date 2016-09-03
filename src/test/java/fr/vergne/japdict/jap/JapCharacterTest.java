package fr.vergne.japdict.jap;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.vergne.japdict.util.StringUtil;

public class JapCharacterTest {
	private static final char HIRAGANA_MIN = '\u3041';
	private static final char HIRAGANA_MAX = '\u3096';
	private static final char KATAKANA_MIN = '\u30A1';
	private static final char KATAKANA_MAX = '\u30FA';
	private static final char KANJI_RARE_MIN = '\u3400';
	private static final char KANJI_RARE_MAX = '\u4DB5';
	private static final char KANJI_MIN = '\u4E01';
	private static final char KANJI_MAX = '\u9FAF';

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
			if (code >= HIRAGANA_MIN && code <= HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (code >= KATAKANA_MIN && code <= KATAKANA_MAX) {
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
		for (char character = HIRAGANA_MIN; character <= HIRAGANA_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message,
					new JapCharacter(character).isKana(KanaType.HIRAGANA));
			assertFalse(message,
					new JapCharacter(character).isKana(KanaType.KATAKANA));
		}
	}

	@Test
	public void testIsKanaTypeCorrectForAllKatakanas() {
		for (char character = KATAKANA_MIN; character <= KATAKANA_MAX; character++) {
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
			if (character >= HIRAGANA_MIN && character <= HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (character >= KATAKANA_MIN && character <= KATAKANA_MAX) {
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
			if (character >= HIRAGANA_MIN && character <= HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (character >= KATAKANA_MIN && character <= KATAKANA_MAX) {
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
		for (char character = HIRAGANA_MIN; character <= HIRAGANA_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKana());
		}
		for (char character = KATAKANA_MIN; character <= KATAKANA_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKana());
		}
	}

	@Test
	public void testIsKanaFalseForAllNonKanas() {
		for (int character = '\u0000'; character <= '\uFFFF'; character++) {
			if (character >= HIRAGANA_MIN && character <= HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (character >= KATAKANA_MIN && character <= KATAKANA_MAX) {
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
		for (char character = KANJI_MIN; character <= KANJI_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKanji());
		}
		for (char character = KANJI_RARE_MIN; character <= KANJI_RARE_MAX; character++) {
			String message = display(character) + " wrongly recognised";
			assertTrue(message, new JapCharacter(character).isKanji());
		}
	}

	@Test
	public void testIsKanjiFalseForAllNonKanjis() {
		for (int character = '\u0000'; character <= '\uFFFF'; character++) {
			if (character >= KANJI_MIN && character <= KANJI_MAX) {
				// ignore usual kanjis
			} else if (character >= KANJI_RARE_MIN
					&& character <= KANJI_RARE_MAX) {
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
			if (character >= HIRAGANA_MIN && character <= HIRAGANA_MAX) {
				assertEquals(message, KanaType.HIRAGANA, type);
			} else if (character >= KATAKANA_MIN && character <= KATAKANA_MAX) {
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
			if (character >= HIRAGANA_MIN && character <= HIRAGANA_MAX) {
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
			} else if (character >= KATAKANA_MIN && character <= KATAKANA_MAX) {
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

	@Test
	public void testToVariantReturnsSelfWithSameVariant() {
		for (char code = HIRAGANA_MIN; code <= HIRAGANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter result = character.toKanaVariant(character
					.getKanaVariant());
			assertEquals(character + " -> " + result, character, result);
		}
		for (char code = KATAKANA_MIN; code <= KATAKANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter result = character.toKanaVariant(character
					.getKanaVariant());
			assertEquals(character + " -> " + result, character, result);
		}
	}

	@Test
	public void testToVariantReturnsProperTenten() {
		String original = "うかきくけこさしすせそたちつてとはひふへほぱぴぷぺぽウカキクケコサシスセソタチツテトハヒフヘホワヲヰヱパピプペポ";
		String transfer = "ゔがぎぐげござじずぜぞだぢづでどばびぶべぼばびぶべぼヴガギグゲゴザジズゼゾダヂヅデドバビブベボヷヺヸヹバビブベボ";
		for (int index = 0; index < original.length(); index++) {
			JapCharacter result = new JapCharacter(original.charAt(index))
					.toKanaVariant(KanaVariant.TENTEN);
			JapCharacter expected = new JapCharacter(transfer.charAt(index));
			assertEquals(expected, result);
		}
	}

	@Test
	public void testToVariantReturnsProperMaru() {
		String original = "はひふへほばびぶべぼハヒフヘホバビブベボ";
		String transfer = "ぱぴぷぺぽぱぴぷぺぽパピプペポパピプペポ";
		for (int index = 0; index < original.length(); index++) {
			JapCharacter result = new JapCharacter(original.charAt(index))
					.toKanaVariant(KanaVariant.MARU);
			JapCharacter expected = new JapCharacter(transfer.charAt(index));
			assertEquals(expected, result);
		}
	}

	@Test
	public void testToVariantReturnsProperSmall() {
		String original = "あいうえおかけつやゆよわゔがげづアイウエオカケツヤユヨワヴガゲヅヷ";
		String transfer = "ぁぃぅぇぉゕゖっゃゅょゎぅゕゖっァィゥェォヵヶッャュョヮゥヵヶッヮ";
		for (int index = 0; index < original.length(); index++) {
			JapCharacter result = new JapCharacter(original.charAt(index))
					.toKanaVariant(KanaVariant.SMALL);
			JapCharacter expected = new JapCharacter(transfer.charAt(index));
			assertEquals(expected, result);
		}
	}

	@Test
	public void testToVariantReturnsProperBase() {
		String original = "ゔがぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽぁぃぅぇぉゕゖっゃゅょゎヴガギグゲゴザジズゼゾダヂヅデドバビブベボヷヺヸヹパピプペポァィゥェォヵヶッャュョヮ";
		String transfer = "うかきくけこさしすせそたちつてとはひふへほはひふへほあいうえおかけつやゆよわウカキクケコサシスセソタチツテトハヒフヘホワヲヰヱハヒフヘホアイウエオカケツヤユヨワ";
		for (int index = 0; index < original.length(); index++) {
			JapCharacter result = new JapCharacter(original.charAt(index))
					.toKanaVariant(KanaVariant.NONE);
			JapCharacter expected = new JapCharacter(transfer.charAt(index));
			assertEquals(expected, result);
		}
	}

	@Test
	public void testToVariantReturnsNullIfNotValid() {
		for (int code = '\u0000'; code <= '\uFFFF'; code++) {
			JapCharacter character = new JapCharacter((char) code);
			if (code >= HIRAGANA_MIN && code <= HIRAGANA_MAX) {
				if ("あいえおなにぬねのまみむめもやゆよらりるれろわをんゐゑ".contains("" + character)) {
					assertEquals(null,
							character.toKanaVariant(KanaVariant.TENTEN));
				}
				if ("あいうえおかきくけこさしすせそたちつてとなにぬねのまみむめもやゆよらりるれろわをんゐゑ".contains(""
						+ character)) {
					assertEquals(null,
							character.toKanaVariant(KanaVariant.MARU));
				}
				if ("きくこさしすせそたちてとなにぬねのはひふへほまみむめもらりるれろをんゐゑ".contains(""
						+ character)) {
					assertEquals(null,
							character.toKanaVariant(KanaVariant.SMALL));
				}
			} else if (code >= KATAKANA_MIN && code <= KATAKANA_MAX) {
				if ("アイエオナニヌネノマミムメモヤユヨラリルレロン".contains("" + character)) {
					assertEquals(null,
							character.toKanaVariant(KanaVariant.TENTEN));
				}
				if ("アイウエオカキクケコサシスセソタチツテトナニヌネノマミムメモヤユヨラリルレロワヲンヰヱ".contains(""
						+ character)) {
					assertEquals(null,
							character.toKanaVariant(KanaVariant.MARU));
				}
				if ("キクコサシスセソタチテトナニヌネノハヒフヘホマミムメモラリルレロヲンヰヱ".contains(""
						+ character)) {
					assertEquals(null,
							character.toKanaVariant(KanaVariant.SMALL));
				}
			} else {
				assertEquals(null, character.toKanaVariant(KanaVariant.NONE));
				assertEquals(null, character.toKanaVariant(KanaVariant.TENTEN));
				assertEquals(null, character.toKanaVariant(KanaVariant.MARU));
				assertEquals(null, character.toKanaVariant(KanaVariant.SMALL));
			}
		}
	}

	@Test
	public void testToTypeReturnsSelfWithSameType() {
		for (char code = HIRAGANA_MIN; code <= HIRAGANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter result = character.toKanaType(character.getKanaType());
			assertEquals(character + " -> " + result, character, result);
		}
		for (char code = KATAKANA_MIN; code <= KATAKANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter result = character.toKanaType(character.getKanaType());
			assertEquals(character + " -> " + result, character, result);
		}
	}

	@Test
	public void testToTypeReturnsProperOtherType() {
		for (char code = HIRAGANA_MIN; code <= HIRAGANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter expected = new JapCharacter((char) ((int) code
					- HIRAGANA_MIN + KATAKANA_MIN));
			JapCharacter result = character.toKanaType(KanaType.KATAKANA);
			assertEquals(character + " -> " + result, expected, result);
		}
		for (char code = KATAKANA_MIN; code <= KATAKANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter expected;
			if ("ヷヺヸヹ".contains("" + code)) {
				expected = null;
			} else {
				expected = new JapCharacter(
						(char) ((int) code - KATAKANA_MIN + HIRAGANA_MIN));
			}
			JapCharacter result = character.toKanaType(KanaType.HIRAGANA);
			assertEquals(character + " -> " + result, expected, result);
		}
	}

	@Test
	public void testToTypeReturnsNullIfNotKana() {
		for (int code = '\u0000'; code <= '\uFFFF'; code++) {
			JapCharacter character = new JapCharacter((char) code);
			if (code >= HIRAGANA_MIN && code <= HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (code >= KATAKANA_MIN && code <= KATAKANA_MAX) {
				// ignore katakanas
			} else {
				assertEquals(null, character.toKanaType(KanaType.HIRAGANA));
				assertEquals(null, character.toKanaType(KanaType.KATAKANA));
			}
		}
	}
}
