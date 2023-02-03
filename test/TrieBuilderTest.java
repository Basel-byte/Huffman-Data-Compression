package org.algo.part2.trie;
import org.algo.part2.utils.ByteArray;
import org.algo.part2.utils.trie.LeafNode;
import org.algo.part2.utils.trie.TrieBuilder;
import org.algo.part2.utils.trie.TrieNode;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TrieBuilderTest {

    @Test
    void buildTrie() throws IOException {
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

        Map<ByteArray, Integer> keyToFreqMap = new HashMap<>();
        keyToFreqMap.put(new ByteArray(new byte[]{102}), 5);
        keyToFreqMap.put(new ByteArray(new byte[]{101}), 9);
        keyToFreqMap.put(new ByteArray(new byte[]{99}), 12);
        keyToFreqMap.put(new ByteArray(new byte[]{98}), 13);
        keyToFreqMap.put(new ByteArray(new byte[]{100}), 16);
        keyToFreqMap.put(new ByteArray(new byte[]{97}), 45);

        // when
        TrieNode expectedRoot = TrieBuilder.buildTrie(keyToFreqMap);

        // then
        assertThat(expectedRoot).isEqualTo(root);
    }
}