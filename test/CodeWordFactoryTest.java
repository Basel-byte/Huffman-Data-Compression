package org.algo.part2;

import org.algo.part2.utils.CodeWord;
import org.algo.part2.utils.CodeWordFactory;
import org.algo.part2.utils.trie.LeafNode;
import org.algo.part2.utils.trie.TrieNode;
import org.algo.part2.utils.ByteArray;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.algo.part2.utils.CodeWordFactory.createBitSet;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class CodeWordFactoryTest {

    @Test
    void buildKeyToCodeWordMap() {
        // given
        TrieNode root = new TrieNode(100);
        root.left = new LeafNode(new byte[]{97}, 45);
        root.right = new TrieNode(55);
        root.right.left = new TrieNode(25);
        root.right.right = new TrieNode(30);
        root.right.left.left = new LeafNode(new byte[]{99}, 12);
        root.right.left.right = new LeafNode(new byte[]{98}, 13);
        root.right.right.left = new TrieNode(14);
        root.right.right.right = new LeafNode(new byte[]{100}, 16);
        root.right.right.left.left = new LeafNode(new byte[]{102}, 5);
        root.right.right.left.right = new LeafNode(new byte[]{101}, 9);

        Map<ByteArray, CodeWord> map = new HashMap<>();
        map.put(new ByteArray(new byte[]{97}), new CodeWord(createBitSet("0"), (short) 1));
        map.put(new ByteArray(new byte[]{99}), new CodeWord(createBitSet("100"), (short) 3));
        map.put(new ByteArray(new byte[]{98}), new CodeWord(createBitSet("101"), (short) 3));
        map.put(new ByteArray(new byte[]{102}), new CodeWord(createBitSet("1100"), (short) 4));
        map.put(new ByteArray(new byte[]{101}), new CodeWord(createBitSet("1101"), (short) 4));
        map.put(new ByteArray(new byte[]{100}), new CodeWord(createBitSet("111"), (short) 3));


        // when
        Map<ByteArray, CodeWord> expectedMap = CodeWordFactory.buildKeyToCodeWordMap(root);

        // then
        assertThat(expectedMap).isEqualTo(map);

    }
}