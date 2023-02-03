package org.algo.part2.utils.trie;

import org.algo.part2.utils.ByteArray;
import org.algo.part2.utils.Util;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TrieBuilder {
    public static TrieNode buildTrie(Map<ByteArray, Integer> keyToFreqMap) {
        PriorityQueue<TrieNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));
        for (Map.Entry<ByteArray, Integer> entry : keyToFreqMap.entrySet())
            pq.add(new LeafNode(entry.getKey().bytes, entry.getValue()));

        int size = keyToFreqMap.size();
        for (int i = 1; i < size; i++) {
            TrieNode newNode = new TrieNode();
            TrieNode left = pq.poll();
            TrieNode right = pq.poll();
            newNode.left = left;
            newNode.right = right;
            newNode.freq = left.freq + right.freq;
            pq.add(newNode);
        }

        return pq.poll();
    }

}
