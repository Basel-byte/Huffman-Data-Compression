package org.algo.part2.utils;

import org.algo.part2.utils.CodeWord;
import org.algo.part2.utils.trie.LeafNode;
import org.algo.part2.utils.trie.TrieNode;
import org.algo.part2.utils.ByteArray;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Util {

    public static String formulateCompressedFilePath(String filePath, int id, int n) {
        Path path = Path.of(filePath);
        String fileName = path.getFileName().toString();
        String parentName = path.getParent().toString();
        return parentName + "\\" + id + '.' + n + '.' + fileName + ".hc";
    }

    public static String formulateDecompressedFilePath(String filePath) {
        Path path = Path.of(filePath);
        String fileName = path.getFileName().toString();
        String parentName = path.getParent().toString();
        return parentName + "\\extracted." + fileName.substring(0, fileName.lastIndexOf('.'));
    }

}
