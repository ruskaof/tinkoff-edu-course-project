package ru.tinkoff.edu.java.linkparser.parser;

import org.jetbrains.annotations.NotNull;

/**
 * This class helps to make a {@link LinkParser} instance using a chain of {@link BaseLinkParser} instances
 * that obey the Chain of Responsibility pattern.
 * Usage example:
 * <code>
 *     LinkParser lp = ChainLinkParserBuilder.from(new GitHubLinkParser()).then(new StackOverflowLinkParser()).build();
 * </code>
 */
public class ChainLinkParserBuilder {
    @NotNull
    private final BaseLinkParser head;
    @NotNull
    private BaseLinkParser tail;

    private ChainLinkParserBuilder(@NotNull BaseLinkParser initialParserNode) {
        this.head = initialParserNode;
        this.tail = initialParserNode;
    }

    @NotNull
    public static ChainLinkParserBuilder startFrom(@NotNull BaseLinkParser baseLinkParser) {
        return new ChainLinkParserBuilder(baseLinkParser);
    }

    @NotNull
    public ChainLinkParserBuilder then(@NotNull BaseLinkParser baseLinkParser) {
        this.tail.setNext(baseLinkParser);
        this.tail = baseLinkParser;
        return this;
    }

    @NotNull
    public LinkParser build() {
        return this.head;
    }
}
