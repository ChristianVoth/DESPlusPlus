/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package Core;

import Core.Event;

public interface EventList {



    public void insert(Event e);


    public Event getFirst();

    public void removeFirst();

    public int remove(Event e);

    public int size();

    public boolean isEmpty();

    public void showList();
}
