package ru.tinkoff.edu.java.linkparser.parser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.tinkoff.edu.java.linkparser.result.ParserResult;

/**
 * A {@link LinkParser} implementation that uses Chain of Responsibility pattern.
 * Is null in case the current link parser is the last one in the chain.
 */
public abstract class BaseLinkParser implements LinkParser {

    /**
     * Is null in case the current link parser is the last one in the chain.
     */
    @Nullable
    protected BaseLinkParser next;

    @Nullable
    protected ParserResult forward(@NotNull String link) {
        return this.next == null ? null : this.next.parseLink(link);
    }

    public void setNext(@NotNull BaseLinkParser next) {
        this.next = next;
    }


}

