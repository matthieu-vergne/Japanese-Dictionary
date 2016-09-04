package fr.vergne.japdict.jap;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

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
	public void testCreateFromRomajiReturnsProperHiragana() {
		KanaFactory factory = new KanaFactory();
		Map<String, Character> expected = new HashMap<>();
		expected.put("a", 'あ');
		expected.put("i", 'い');
		expected.put("u", 'う');
		expected.put("e", 'え');
		expected.put("o", 'お');
		expected.put("ka", 'か');
		expected.put("ki", 'き');
		expected.put("ku", 'く');
		expected.put("ke", 'け');
		expected.put("ko", 'こ');
		expected.put("sa", 'さ');
		expected.put("shi", 'し');
		expected.put("su", 'す');
		expected.put("se", 'せ');
		expected.put("so", 'そ');
		expected.put("ta", 'た');
		expected.put("chi", 'ち');
		expected.put("tsu", 'つ');
		expected.put("te", 'て');
		expected.put("to", 'と');
		expected.put("na", 'な');
		expected.put("ni", 'に');
		expected.put("nu", 'ぬ');
		expected.put("ne", 'ね');
		expected.put("no", 'の');
		expected.put("ha", 'は');
		expected.put("hi", 'ひ');
		expected.put("hu", 'ふ');
		expected.put("fu", 'ふ');
		expected.put("he", 'へ');
		expected.put("ho", 'ほ');
		expected.put("ma", 'ま');
		expected.put("mi", 'み');
		expected.put("mu", 'む');
		expected.put("me", 'め');
		expected.put("mo", 'も');
		expected.put("ya", 'や');
		expected.put("yu", 'ゆ');
		expected.put("yo", 'よ');
		expected.put("ra", 'ら');
		expected.put("ri", 'り');
		expected.put("ru", 'る');
		expected.put("re", 'れ');
		expected.put("ro", 'ろ');
		expected.put("wa", 'わ');
		expected.put("wo", 'を');
		expected.put("n", 'ん');

		expected.put("wi", 'ゐ');
		expected.put("we", 'ゑ');

		expected.put("vu", 'ゔ');
		expected.put("ga", 'が');
		expected.put("gi", 'ぎ');
		expected.put("gu", 'ぐ');
		expected.put("ge", 'げ');
		expected.put("go", 'ご');
		expected.put("za", 'ざ');
		expected.put("ji", 'じ');
		expected.put("zu", 'ず');
		expected.put("ze", 'ぜ');
		expected.put("zo", 'ぞ');
		expected.put("da", 'だ');
		expected.put("dji", 'ぢ');
		expected.put("dzu", 'づ');
		expected.put("de", 'で');
		expected.put("do", 'ど');
		expected.put("ba", 'ば');
		expected.put("bi", 'び');
		expected.put("bu", 'ぶ');
		expected.put("be", 'べ');
		expected.put("bo", 'ぼ');

		expected.put("pa", 'ぱ');
		expected.put("pi", 'ぴ');
		expected.put("pu", 'ぷ');
		expected.put("pe", 'ぺ');
		expected.put("po", 'ぽ');

		expected.put("+a", 'ぁ');
		expected.put("+i", 'ぃ');
		expected.put("+u", 'ぅ');
		expected.put("+e", 'ぇ');
		expected.put("+o", 'ぉ');
		expected.put("+ka", 'ゕ');
		expected.put("+ke", 'ゖ');
		expected.put("+tsu", 'っ');
		expected.put("+ya", 'ゃ');
		expected.put("+yu", 'ゅ');
		expected.put("+yo", 'ょ');
		expected.put("+wa", 'ゎ');

		for (Entry<String, Character> entry : expected.entrySet()) {
			String romaji = entry.getKey();
			char jap = entry.getValue();
			assertEquals("For " + romaji + ": ", "" + jap, factory
					.createFromRomaji(romaji, KanaType.HIRAGANA).toString());
		}
	}

	@Test
	public void testCreateFromRomajiReturnsProperKatakana() {
		KanaFactory factory = new KanaFactory();
		Map<String, Character> expected = new HashMap<>();
		expected.put("a", 'ア');
		expected.put("i", 'イ');
		expected.put("u", 'ウ');
		expected.put("e", 'エ');
		expected.put("o", 'オ');
		expected.put("ka", 'カ');
		expected.put("ki", 'キ');
		expected.put("ku", 'ク');
		expected.put("ke", 'ケ');
		expected.put("ko", 'コ');
		expected.put("sa", 'サ');
		expected.put("shi", 'シ');
		expected.put("su", 'ス');
		expected.put("se", 'セ');
		expected.put("so", 'ソ');
		expected.put("ta", 'タ');
		expected.put("chi", 'チ');
		expected.put("tsu", 'ツ');
		expected.put("te", 'テ');
		expected.put("to", 'ト');
		expected.put("na", 'ナ');
		expected.put("ni", 'ニ');
		expected.put("nu", 'ヌ');
		expected.put("ne", 'ネ');
		expected.put("no", 'ノ');
		expected.put("ha", 'ハ');
		expected.put("hi", 'ヒ');
		expected.put("hu", 'フ');
		expected.put("fu", 'フ');
		expected.put("he", 'ヘ');
		expected.put("ho", 'ホ');
		expected.put("ma", 'マ');
		expected.put("mi", 'ミ');
		expected.put("mu", 'ム');
		expected.put("me", 'メ');
		expected.put("mo", 'モ');
		expected.put("ya", 'ヤ');
		expected.put("yu", 'ユ');
		expected.put("yo", 'ヨ');
		expected.put("ra", 'ラ');
		expected.put("ri", 'リ');
		expected.put("ru", 'ル');
		expected.put("re", 'レ');
		expected.put("ro", 'ロ');
		expected.put("wa", 'ワ');
		expected.put("wo", 'ヲ');
		expected.put("n", 'ン');

		expected.put("wi", 'ヰ');
		expected.put("we", 'ヱ');

		expected.put("vu", 'ヴ');
		expected.put("ga", 'ガ');
		expected.put("gi", 'ギ');
		expected.put("gu", 'グ');
		expected.put("ge", 'ゲ');
		expected.put("go", 'ゴ');
		expected.put("za", 'ザ');
		expected.put("ji", 'ジ');
		expected.put("zu", 'ズ');
		expected.put("ze", 'ゼ');
		expected.put("zo", 'ゾ');
		expected.put("da", 'ダ');
		expected.put("dji", 'ヂ');
		expected.put("dzu", 'ヅ');
		expected.put("de", 'デ');
		expected.put("do", 'ド');
		expected.put("ba", 'バ');
		expected.put("bi", 'ビ');
		expected.put("bu", 'ブ');
		expected.put("be", 'ベ');
		expected.put("bo", 'ボ');

		expected.put("pa", 'パ');
		expected.put("pi", 'ピ');
		expected.put("pu", 'プ');
		expected.put("pe", 'ペ');
		expected.put("po", 'ポ');

		expected.put("+a", 'ァ');
		expected.put("+i", 'ィ');
		expected.put("+u", 'ゥ');
		expected.put("+e", 'ェ');
		expected.put("+o", 'ォ');
		expected.put("+ka", 'ヵ');
		expected.put("+ke", 'ヶ');
		expected.put("+tsu", 'ッ');
		expected.put("+ya", 'ャ');
		expected.put("+yu", 'ュ');
		expected.put("+yo", 'ョ');
		expected.put("+wa", 'ヮ');

		for (Entry<String, Character> entry : expected.entrySet()) {
			String romaji = entry.getKey();
			char jap = entry.getValue();
			assertEquals("For " + romaji + ": ", "" + jap, factory
					.createFromRomaji(romaji, KanaType.KATAKANA).toString());
		}
	}

	@Test
	public void testCreateFromRomajiIsCaseInsensitive() {
		KanaFactory factory = new KanaFactory();
		Collection<String> list = new LinkedList<>();
		list.add("a");
		list.add("i");
		list.add("u");
		list.add("e");
		list.add("o");
		list.add("ka");
		list.add("ki");
		list.add("ku");
		list.add("ke");
		list.add("ko");
		list.add("sa");
		list.add("shi");
		list.add("su");
		list.add("se");
		list.add("so");
		list.add("ta");
		list.add("chi");
		list.add("tsu");
		list.add("te");
		list.add("to");
		list.add("na");
		list.add("ni");
		list.add("nu");
		list.add("ne");
		list.add("no");
		list.add("ha");
		list.add("hi");
		list.add("hu");
		list.add("fu");
		list.add("he");
		list.add("ho");
		list.add("ma");
		list.add("mi");
		list.add("mu");
		list.add("me");
		list.add("mo");
		list.add("ya");
		list.add("yu");
		list.add("yo");
		list.add("ra");
		list.add("ri");
		list.add("ru");
		list.add("re");
		list.add("ro");
		list.add("wa");
		list.add("wo");
		list.add("n");

		list.add("wi");
		list.add("we");

		list.add("vu");
		list.add("ga");
		list.add("gi");
		list.add("gu");
		list.add("ge");
		list.add("go");
		list.add("za");
		list.add("ji");
		list.add("zu");
		list.add("ze");
		list.add("zo");
		list.add("da");
		list.add("dji");
		list.add("dzu");
		list.add("de");
		list.add("do");
		list.add("ba");
		list.add("bi");
		list.add("bu");
		list.add("be");
		list.add("bo");

		list.add("pa");
		list.add("pi");
		list.add("pu");
		list.add("pe");
		list.add("po");

		list.add("+a");
		list.add("+i");
		list.add("+u");
		list.add("+e");
		list.add("+o");
		list.add("+ka");
		list.add("+ke");
		list.add("+tsu");
		list.add("+ya");
		list.add("+yu");
		list.add("+yo");
		list.add("+wa");

		for (String romaji : Arrays.asList("a", "hi", "bu", "po", "we")) {
			String low = romaji.toLowerCase();
			String up = romaji.toUpperCase();

			/*
			 * Preliminary tests to ensure that modifications above do not
			 * change the purpose of the test.
			 */
			assertTrue("Test corrupted!", Character.isLowerCase(low.charAt(0)));
			assertTrue("Test corrupted!", Character.isUpperCase(up.charAt(0)));

			assertEquals("For " + romaji + ": ",
					factory.createFromRomaji(low, KanaType.HIRAGANA),
					factory.createFromRomaji(up, KanaType.HIRAGANA));
			assertEquals("For " + romaji + ": ",
					factory.createFromRomaji(low, KanaType.KATAKANA),
					factory.createFromRomaji(up, KanaType.KATAKANA));
		}
	}

	@Test
	public void testCreateFromRomajiThrowsExceptionForNullTypes() {
		KanaFactory factory = new KanaFactory();
		try {
			factory.createFromRomaji("A", null);
			fail("No exception thrown");
		} catch (NullPointerException | IllegalArgumentException e) {
		}
	}

	@Test
	public void testCreateFromRomajiThrowsExceptionForNullString() {
		KanaFactory factory = new KanaFactory();
		try {
			factory.createFromRomaji(null, KanaType.HIRAGANA);
			fail("No exception thrown");
		} catch (NullPointerException | IllegalArgumentException e) {
		}
	}

	@Test
	public void testCreateFromRomajiThrowsExceptionForEmptyString() {
		KanaFactory factory = new KanaFactory();
		try {
			factory.createFromRomaji("", KanaType.HIRAGANA);
			fail("No exception thrown");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testCreateFromRomajiThrowsExceptionForInvalidString() {
		KanaFactory factory = new KanaFactory();
		try {
			factory.createFromRomaji("kya", KanaType.HIRAGANA);
			fail("No exception thrown");
		} catch (IllegalArgumentException e) {
		}
	}

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
