package ru.tinkoff.edu.java.linkparser.result;

import org.jetbrains.annotations.NotNull;

public record GitHubParserResult(
        @NotNull String username,
        @NotNull String repository) implements ParserResult {
}
