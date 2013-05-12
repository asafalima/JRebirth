package org.jrebirth.core.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JRebirthThreadPoolExecutor extends ThreadPoolExecutor {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JRebirthThreadPoolExecutor.class);

    public JRebirthThreadPoolExecutor(final int threadNumber, final ThreadFactory threadFactory) {
        super(threadNumber, threadNumber, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void afterExecute(final Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t == null && r instanceof Future<?>) {
            try {
                final Object result = ((Future<?>) r).get();
            } catch (final CancellationException ce) {
                t = ce;
            } catch (final ExecutionException ee) {
                t = ee.getCause();
            } catch (final InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        }
        if (t != null)
        {
            LOGGER.error("JTP returned an error", t);
        }
    }
}