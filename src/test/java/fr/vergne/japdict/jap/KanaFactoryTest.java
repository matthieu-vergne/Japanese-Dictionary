package fr.vergne.japdict.jap;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A {@link KanaFactory} provides facilities to create and transform
 * {@link JapCharacter}s representing kanas.
 * 
 * @author Matthieu Vergne <matthieu.vergne@gmail.com>
 * 
 */
public class KanaFactoryTest {

	@Test
	public void testTransformReturnsSelfWithSameVariant() {
		KanaFactory factory = new KanaFactory();
		for (char code = JapUnicode.HIRAGANA_MIN; code <= JapUnicode.HIRAGANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter result = factory.transform(character,
					character.getKanaVariant());
			assertEquals(character + " -> " + result, character, result);
		}
		for (char code = JapUnicode.KATAKANA_MIN; code <= JapUnicode.KATAKANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter result = factory.transform(character,
					character.getKanaVariant());
			assertEquals(character + " -> " + result, character, result);
		}
	}

	@Test
	public void testTransformReturnsProperTenten() {
		String original = "うかきくけこさしすせそたちつてとはひふへほぱぴぷぺぽウカキクケコサシスセソタチツテトハヒフヘホワヲヰヱパピプペポ";
		String transfer = "ゔがぎぐげござじずぜぞだぢづでどばびぶべぼばびぶべぼヴガギグゲゴザジズゼゾダヂヅデドバビブベボヷヺヸヹバビブベボ";
		KanaFactory factory = new KanaFactory();
		for (int index = 0; index < original.length(); index++) {
			JapCharacter result = factory.transform(
					new JapCharacter(original.charAt(index)),
					KanaVariant.TENTEN);
			JapCharacter expected = new JapCharacter(transfer.charAt(index));
			assertEquals(expected, result);
		}
	}

	@Test
	public void testTransformReturnsProperMaru() {
		String original = "はひふへほばびぶべぼハヒフヘホバビブベボ";
		String transfer = "ぱぴぷぺぽぱぴぷぺぽパピプペポパピプペポ";
		KanaFactory factory = new KanaFactory();
		for (int index = 0; index < original.length(); index++) {
			JapCharacter result = factory.transform(
					new JapCharacter(original.charAt(index)), KanaVariant.MARU);
			JapCharacter expected = new JapCharacter(transfer.charAt(index));
			assertEquals(expected, result);
		}
	}

	@Test
	public void testTransformReturnsProperSmall() {
		String original = "あいうえおかけつやゆよわゔがげづアイウエオカケツヤユヨワヴガゲヅヷ";
		String transfer = "ぁぃぅぇぉゕゖっゃゅょゎぅゕゖっァィゥェォヵヶッャュョヮゥヵヶッヮ";
		KanaFactory factory = new KanaFactory();
		for (int index = 0; index < original.length(); index++) {
			JapCharacter result = factory
					.transform(new JapCharacter(original.charAt(index)),
							KanaVariant.SMALL);
			JapCharacter expected = new JapCharacter(transfer.charAt(index));
			assertEquals(expected, result);
		}
	}

	@Test
	public void testTransformReturnsProperBase() {
		String original = "ゔがぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽぁぃぅぇぉゕゖっゃゅょゎヴガギグゲゴザジズゼゾダヂヅデドバビブベボヷヺヸヹパピプペポァィゥェォヵヶッャュョヮ";
		String transfer = "うかきくけこさしすせそたちつてとはひふへほはひふへほあいうえおかけつやゆよわウカキクケコサシスセソタチツテトハヒフヘホワヲヰヱハヒフヘホアイウエオカケツヤユヨワ";
		KanaFactory factory = new KanaFactory();
		for (int index = 0; index < original.length(); index++) {
			JapCharacter result = factory.transform(
					new JapCharacter(original.charAt(index)), KanaVariant.NONE);
			JapCharacter expected = new JapCharacter(transfer.charAt(index));
			assertEquals(expected, result);
		}
	}

	@Test
	public void testTransformReturnsNullIfNotValidVariant() {
		KanaFactory factory = new KanaFactory();
		for (int code = '\u0000'; code <= '\uFFFF'; code++) {
			JapCharacter character = new JapCharacter((char) code);
			if (code >= JapUnicode.HIRAGANA_MIN
					&& code <= JapUnicode.HIRAGANA_MAX) {
				if ("あいえおなにぬねのまみむめもやゆよらりるれろわをんゐゑ".contains("" + character)) {
					assertEquals(null,
							factory.transform(character, KanaVariant.TENTEN));
				}
				if ("あいうえおかきくけこさしすせそたちつてとなにぬねのまみむめもやゆよらりるれろわをんゐゑ".contains(""
						+ character)) {
					assertEquals(null,
							factory.transform(character, KanaVariant.MARU));
				}
				if ("きくこさしすせそたちてとなにぬねのはひふへほまみむめもらりるれろをんゐゑ".contains(""
						+ character)) {
					assertEquals(null,
							factory.transform(character, KanaVariant.SMALL));
				}
			} else if (code >= JapUnicode.KATAKANA_MIN
					&& code <= JapUnicode.KATAKANA_MAX) {
				if ("アイエオナニヌネノマミムメモヤユヨラリルレロン".contains("" + character)) {
					assertEquals(null,
							factory.transform(character, KanaVariant.TENTEN));
				}
				if ("アイウエオカキクケコサシスセソタチツテトナニヌネノマミムメモヤユヨラリルレロワヲンヰヱ".contains(""
						+ character)) {
					assertEquals(null,
							factory.transform(character, KanaVariant.MARU));
				}
				if ("キクコサシスセソタチテトナニヌネノハヒフヘホマミムメモラリルレロヲンヰヱ".contains(""
						+ character)) {
					assertEquals(null,
							factory.transform(character, KanaVariant.SMALL));
				}
			} else {
				assertEquals(null,
						factory.transform(character, KanaVariant.NONE));
				assertEquals(null,
						factory.transform(character, KanaVariant.TENTEN));
				assertEquals(null,
						factory.transform(character, KanaVariant.MARU));
				assertEquals(null,
						factory.transform(character, KanaVariant.SMALL));
			}
		}
	}

	@Test
	public void testTransformReturnsSelfWithSameType() {
		KanaFactory factory = new KanaFactory();
		for (char code = JapUnicode.HIRAGANA_MIN; code <= JapUnicode.HIRAGANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter result = factory.transform(character,
					character.getKanaType());
			assertEquals(character + " -> " + result, character, result);
		}
		for (char code = JapUnicode.KATAKANA_MIN; code <= JapUnicode.KATAKANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter result = factory.transform(character,
					character.getKanaType());
			assertEquals(character + " -> " + result, character, result);
		}
	}

	@Test
	public void testTransformReturnsProperOtherType() {
		KanaFactory factory = new KanaFactory();
		for (char code = JapUnicode.HIRAGANA_MIN; code <= JapUnicode.HIRAGANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter expected = new JapCharacter((char) ((int) code
					- JapUnicode.HIRAGANA_MIN + JapUnicode.KATAKANA_MIN));
			JapCharacter result = factory.transform(character,
					KanaType.KATAKANA);
			assertEquals(character + " -> " + result, expected, result);
		}
		for (char code = JapUnicode.KATAKANA_MIN; code <= JapUnicode.KATAKANA_MAX; code++) {
			JapCharacter character = new JapCharacter(code);
			JapCharacter expected;
			if ("ヷヺヸヹ".contains("" + code)) {
				expected = null;
			} else {
				expected = new JapCharacter((char) ((int) code
						- JapUnicode.KATAKANA_MIN + JapUnicode.HIRAGANA_MIN));
			}
			JapCharacter result = factory.transform(character,
					KanaType.HIRAGANA);
			assertEquals(character + " -> " + result, expected, result);
		}
	}

	@Test
	public void testTransformReturnsNullIfNotValidType() {
		KanaFactory factory = new KanaFactory();
		for (int code = '\u0000'; code <= '\uFFFF'; code++) {
			JapCharacter character = new JapCharacter((char) code);
			if (code >= JapUnicode.HIRAGANA_MIN
					&& code <= JapUnicode.HIRAGANA_MAX) {
				// ignore hiraganas
			} else if (code >= JapUnicode.KATAKANA_MIN
					&& code <= JapUnicode.KATAKANA_MAX) {
				// ignore katakanas
			} else {
				assertEquals(null,
						factory.transform(character, KanaType.HIRAGANA));
				assertEquals(null,
						factory.transform(character, KanaType.KATAKANA));
			}
		}
	}
}
