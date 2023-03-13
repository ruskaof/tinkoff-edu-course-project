package ru.tinkoff.edu.java.linkparser.parser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.tinkoff.edu.java.linkparser.result.ParserResult;


public interface LinkParser {
    /**
     * Parses the given link to a {@link ParserResult} instance.
     *
     * @param link the link to be parsed. May or may not contain protocol or
     *             subdomain.
     * @return null if wasn't able to parse the link, a {@link ParserResult}
     * otherwise.
     */
    @Nullable
    ParserResult parseLink(@NotNull String link);
}
