package ru.tinkoff.edu.java.linkparser.result;

import org.jetbrains.annotations.NotNull;

public record StackOverflowParserResult(@NotNull String questionId) implements ParserResult {
}
