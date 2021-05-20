package de.uniheidelberg.cl.java.ex04;

import ex04.TokenMother;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ex04.TaggableMother;
import ex04.TaggedMother;
import ex04.DependencyMother;


public class SentenceUtils {
	public static String getLongestToken(TokenMother sentence) {
		/* Gets the longest token (in characters) in sentence.
		 *
		 */
		if (sentence.getLength() == 0) {
			return null;
		}

		String longest = sentence.getTokenText(0);
		for (int i = 1; i < sentence.getLength(); i++) {
			String token = sentence.getTokenText(i);

			if (token.length() > longest.length()) {
				longest = token;
			}
		}

		return longest;
	}

	public static void tagRandomly(TaggableMother sentence) {
		/* Randomly assigns tags to sentence
		 *
		 */
		Random rand = new Random();
		String[] tags = {"NN", "DT", "VBZ", "VFIN"};
		for (int i = 0; i < sentence.getLength(); i++) {
			String tag = tags[rand.nextInt(tags.length)];
			sentence.setTokenTag(i, tag);
		}
	}

	public static void printTags(TaggedMother sentence) {
		/* Prints words and tags of sentence on the command line
		 *
		 */
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < sentence.getLength(); i++) {
			String word = sentence.getTokenText(i);
			String tag = sentence.getTokenTag(i);
			builder.append(word);
			builder.append("/");
			builder.append(tag);
			if (i < sentence.getLength() - 1) {
				builder.append(" ");
			}
		}
		System.out.println(builder.toString());
	}

	public static List<String> findLeafRelations(DependencyMother sentence) {
		/* Returns all relations that are incoming to leaf nodes
		 *
		 */
		boolean[] isParent = new boolean[sentence.getLength()];

		for (int i = 0; i < sentence.getLength(); i++) {
			int tokHead = sentence.getTokenHead(i);
			if (tokHead == 0) {
				continue;
			}
			isParent[tokHead - 1] = true;
		}

		List<String> leafRels = new ArrayList<>();
		for (int i = 0; i < sentence.getLength(); i++) {
			if (!isParent[i]) {
				leafRels.add(sentence.getTokenRel(i));
			}
		}

		return leafRels;
	}

	public static String highlightSentence(TaggedMother sentence, String tag) {
		String sentenceString = "";
		for (int word = 0; word < sentence.getLength(); word++) {
			if (sentence.getTokenTag(word).equals(tag)) {
				sentenceString = new StringBuilder().append(sentenceString).append("*").append(sentence.getTokenText(word).toUpperCase()).append("* ").toString();
			} else {
				sentenceString = new StringBuilder().append(sentenceString).append(sentence.getTokenText(word)).append(" ").toString();
			}
		}
		return sentenceString = new StringBuilder().append(sentenceString).append(".").toString();
	}

	public static void main(String[] args) {
		// List<T> is javas variant of a variable length list.
		// We will look into this in detail in a future lecture.
		List<String> words = new ArrayList<>();
		words.add("This");
		words.add("is");
		words.add("a");
		words.add("test");
		List<String> pos = new ArrayList<>();
		pos.add("DT");
		pos.add("VFIN");
		pos.add("DT");
		pos.add("NN");
		List<Integer> heads = new ArrayList<>();
		heads.add(4);
		heads.add(4);
		heads.add(4);
		heads.add(0);
		List<String> rels = new ArrayList<>();
		rels.add("nsubj");
		rels.add("cop");
		rels.add("det");
		rels.add("root");

		Sentence sentence = new Sentence(words);
		TaggedSentence taggedSentence = new TaggedSentence(words, pos);
		TaggableSentence taggableSentence = new TaggableSentence(words, pos);
		DependencySentence dependencySentence = new DependencySentence(words, heads, rels);

		List<Token> tokens = new ArrayList<>();
		for (int i = 0; i < words.size(); i++) {
			Token tok = new Token(i + 1, words.get(i), words.get(i), pos.get(i), heads.get(i), rels.get(i));
			tokens.add(tok);
		}

		TokenSentence tokenSentence = new TokenSentence(tokens);

		System.out.println(getLongestToken(sentence));
		System.out.println(getLongestToken(taggedSentence));
		System.out.println(getLongestToken(dependencySentence));
		// Uncomment to check your solution
		System.out.println(getLongestToken(tokenSentence));

		tagRandomly(taggableSentence);
		tagRandomly(tokenSentence);

		printTags(taggedSentence);
		printTags(taggableSentence);
		printTags(tokenSentence);

		System.out.println(findLeafRelations(dependencySentence));
		System.out.println(findLeafRelations(tokenSentence));

		//Uncomment to test PointerToken
		String originalText = "This is  a test";
		List<Token> pointerTokens = new ArrayList<>();
		pointerTokens.add(new PointerToken(1, originalText, 0, 4, "This", "DT", 4, "nsubj"));
		pointerTokens.add(new PointerToken(2, originalText, 5, 2, "be", "DT", 4, "nsubj"));
		pointerTokens.add(new PointerToken(3, originalText, 9, 1, "a", "DT", 4, "nsubj"));
		pointerTokens.add(new PointerToken(4, originalText, 11, 4, "test", "DT", 4, "nsubj"));

		TokenSentence tokenSentenceWithIndex = new TokenSentence(pointerTokens);
		printTags(tokenSentenceWithIndex);


		//Uncomment to test highlightTokens
		System.out.println(highlightSentence(taggedSentence, "DT"));
		System.out.println(highlightSentence(tokenSentence, "DT"));



	}
}
