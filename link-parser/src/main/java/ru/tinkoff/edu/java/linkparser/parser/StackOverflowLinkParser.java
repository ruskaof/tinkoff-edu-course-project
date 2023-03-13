package ru.tinkoff.edu.java.linkparser.parser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.tinkoff.edu.java.linkparser.result.ParserResult;
import ru.tinkoff.edu.java.linkparser.result.StackOverflowParserResult;

import java.util.regex.Pattern;

public class StackOverflowLinkParser extends BaseLinkParser {
    private static final Pattern QUESTION_PATTERN = Pattern.compile(
            "^(?:https://)?(?:www\\.)?stackoverflow\\.com/questions/(?<id>\\d+)(?:/?|/[a-zA-Z\\-]+/?)$"
    );
    @Override
    @Nullable
    public ParserResult parseLink(@NotNull String link) {
        final var matcher = QUESTION_PATTERN.matcher(link);

        if (matcher.matches()) {
            return new StackOverflowParserResult(matcher.group("id"));
        } else {
            return forward(link);
        }
    }
}
