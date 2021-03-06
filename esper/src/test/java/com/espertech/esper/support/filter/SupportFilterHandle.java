/*
 * *************************************************************************************
 *  Copyright (C) 2006-2015 EsperTech, Inc. All rights reserved.                       *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 * *************************************************************************************
 */

package com.espertech.esper.support.filter;

import com.espertech.esper.filter.FilterHandleCallback;
import com.espertech.esper.client.EventBean;

import java.util.Collection;

public class SupportFilterHandle implements FilterHandleCallback
{
    private int countInvoked;
    private EventBean lastEvent;

    public void matchFound(EventBean theEvent, Collection<FilterHandleCallback> allStmtMatches)
    {
        countInvoked++;
        lastEvent = theEvent;
    }

    public boolean isSubSelect()
    {
        return false;
    }

    public int getCountInvoked()
    {
        return countInvoked;
    }

    public EventBean getLastEvent()
    {
        return lastEvent;
    }

    public void setCountInvoked(int countInvoked)
    {
        this.countInvoked = countInvoked;
    }

    public void setLastEvent(EventBean lastEvent)
    {
        this.lastEvent = lastEvent;
    }

    public int getAndResetCountInvoked()
    {
        int count = countInvoked;
        countInvoked = 0;
        return count;
    }

    public String getStatementId()
    {
        return "";
    }
}
