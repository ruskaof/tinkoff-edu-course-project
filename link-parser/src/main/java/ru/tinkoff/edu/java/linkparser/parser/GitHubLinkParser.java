package ru.tinkoff.edu.java.linkparser.parser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.tinkoff.edu.java.linkparser.result.GitHubParserResult;
import ru.tinkoff.edu.java.linkparser.result.ParserResult;

import java.util.regex.Pattern;

public class GitHubLinkParser extends BaseLinkParser {
    /**
     * Regex that matches the rules of GitHub username:
     * <ul>
     *     <li>Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen.</li>
     *     <li>Maximum is 39 characters.</li>
     * </ul>
     */
    private static final String USERNAME_REGEX = "[a-zA-Z\\d](?:[a-zA-Z\\d]|-(?=[a-zA-Z\\d])){1,38}";
    private static final String REPOSITORY_NAME_REGEX = "[a-zA-Z\\d._\\-]";

    private static final Pattern REPOSITORY_PATTERN = Pattern.compile(
            "^(?:https://)?(?:www\\.)?github\\.com" +
                    "/" +
                    "(?<username>" + USERNAME_REGEX + ")" +
                    "/" +
                    "(?<repository>" + REPOSITORY_NAME_REGEX + "+)/?$"
    );


    @Override
    @Nullable
    public ParserResult parseLink(@NotNull String link) {
        final var matcher = REPOSITORY_PATTERN.matcher(link);

        if (matcher.matches()) {
            return new GitHubParserResult(matcher.group("username"), matcher.group("repository"));
        } else {
            return forward(link);
        }
    }
}
