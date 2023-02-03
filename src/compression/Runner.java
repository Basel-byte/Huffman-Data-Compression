package org.algo.part2.compression;

import org.algo.part2.utils.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Runner {
    /* “I acknowledge that I am aware of the academic integrity guidelines of this
    course, and that I worked on this assignment independently without any
    unauthorized help”. */
    private static void runCompression(String filePath, int n) throws IOException {
        String compressedFilePath = Util.formulateCompressedFilePath(filePath, 19015513, n);
        long fileSize = Files.size(Path.of(filePath));
        long s = System.currentTimeMillis();
        Compressor.compressFile(filePath, compressedFilePath, n);
        long compressedFileSize = Files.size(Path.of(compressedFilePath));
        System.out.println("Compression Time : " + (System.currentTimeMillis() - s));
        System.out.println("Compression Ratio : " + (double) compressedFileSize / (double) fileSize);
    }

    private static void runDecompression(String filePath) throws IOException, ClassNotFoundException {
        String decompressedFilePath = Util.formulateDecompressedFilePath(filePath);
        long s = System.currentTimeMillis();
        Decompressor.decompressFile(filePath, decompressedFilePath);
        System.out.println("Decompression Time : " + (System.currentTimeMillis() - s));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String flag = args[0];
        if (flag.equals("c"))
            runCompression(args[1], Integer.parseInt(args[2]));
        else if (flag.equals("d"))
            runDecompression(args[1]);
        else
            System.out.println("Invalid Command !");
    }

}
