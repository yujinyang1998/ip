# User Guide

## Features 

### Feature 1: todo
Adds a task

    Usage:
    format - todo <name of task>

Example of usage: 

    todo eat beans

Expected outcome:

    todo eat beans
    Got it. I've added this task:
    [T][✘]eat beans
    Now you have 14 tasks in the list.
### Feature 2: deadline
Adds a deadline

    Usage:
    format - deadline <name of deadline> /by <deadline of task>

Example of usage: 

    deadline eat beans /by wednesday next week

Expected outcome:

    deadline eat beans /by wednesday next week
    Got it. I've added this task:
    [D][✘]eat beans (by: wednesday next week)
    Now you have 2 tasks in the list.
### Feature 3: event
Adds a event

    Usage:
    format - event <name of event> /at <time of task>

Example of usage: 

    event eat apples /at 090620 10am

Expected outcome:

    event eat apples /at 090620 10am
    Got it. I've added this task:
    [E][✘]eat apples (at: 090620 10am)
    Now you have 3 tasks in the list.
### Feature 4: list
Lists all added tasks

    Usage:
    format - list

Example of usage: 

    list

Expected outcome:

    list
    1.[T][✘]eat beans
    2.[D][✘]eat beans (by: wednesday next week)
    3.[E][✘]eat apples (at: 090620 10am)
### Feature 5: done
Marks a task as done

    Usage:
    format - done <index of task>

Example of usage: 

    done 2

Expected outcome:

    done 2
    Nice! I've marked this task as done: 
    [D][✓]eat beans (by: wednesday next week)
### Feature 6: delete
deletes a task

    Usage:
    format - delete <index of task>

Example of usage: 

    delete 2

Expected outcome:

    delete 2
    Noted. I've removed this task:
    [D][✓]eat beans (by: wednesday next week)
    Now you have 2 tasks in the list.

### Feature 7: find
deletes a task

    Usage:
    format - find <name of thing to find>

Example of usage: 

    find apple

Expected outcome:

    find apple
    Here are the matching tasks in your list:
    1.[E][✘]eat apples (at: 090620 10am)

### Feature 8: bye
Closes Duke

    Usage:
    format - bye

Example of usage: 

    bye

Expected outcome:

    bye
    Bye. Hope to see you again soon!
