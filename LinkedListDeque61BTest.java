import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class LinkedListDeque61BTest {


    @Test
    public void testElementRemoval() {
        Deque61B<Integer> deque = new LinkedListDeque61B<>();

        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        deque.addLast(40);

        assertThat(deque.removeFirst()).isEqualTo(10);
        assertThat(deque.size()).isEqualTo(3);

        assertThat(deque.removeLast()).isEqualTo(40);
        assertThat(deque.size()).isEqualTo(2);

        assertThat(deque.removeFirst()).isEqualTo(20);
        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.get(0)).isEqualTo(30);

        deque = new LinkedListDeque61B<>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        deque.addLast(40);

        assertThat(deque.removeLast()).isEqualTo(40);
        assertThat(deque.size()).isEqualTo(3);
        assertThat(deque.removeLast()).isEqualTo(30);
        assertThat(deque.size()).isEqualTo(2);
        assertThat(deque.removeLast()).isEqualTo(20);
        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.get(deque.size()-1)).isEqualTo(10);

        deque = new LinkedListDeque61B<>();
        deque.addLast(10);
        deque.addLast(20);

        assertThat(deque.removeFirst()).isEqualTo(10);
        assertThat(deque.removeFirst()).isEqualTo(20);
        assertThat(deque.isEmpty()).isTrue();

        deque = new LinkedListDeque61B<>();
        deque.addLast(10);
        deque.addLast(20);

        assertThat(deque.removeLast()).isEqualTo(20);
        assertThat(deque.removeLast()).isEqualTo(10);
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    public void testRemoveLastSequence() {
        Deque61B<String> list = new LinkedListDeque61B<>();
        list.addFirst("a");
        list.addLast("b");
        list.addLast("c");
        assertThat(list.toList()).containsExactly("a", "b", "c").inOrder();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        assertThat(list.toList()).containsExactly();
        assertThat(list.toList()).isEmpty();
    }

    @Test
    public void testAddFirstToEmptyDeque() {
        LinkedListDeque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addFirst(10);

        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.get(0)).isEqualTo(10);
    }

    @Test
    public void testAddLastToEmptyDeque() {
        LinkedListDeque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(20);

        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.get(0)).isEqualTo(20);
        assertThat(deque.get(1)).isNull();
    }

    @Test
    public void testAddFirstExistingElements() {
        LinkedListDeque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(30);
        deque.addFirst(40);

        assertThat(deque.size()).isEqualTo(2);
        assertThat(deque.get(1)).isEqualTo(30);
        assertThat(deque.get(0)).isEqualTo(40);
    }
    @Test
    public void testAddLastExistingElements() {
        LinkedListDeque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addFirst(50);
        deque.addLast(60);

        assertThat(deque.size()).isEqualTo(2);
        assertThat(deque.get(0)).isEqualTo(50);
        assertThat(deque.get(1)).isEqualTo(60);
    }

    @Test
    public void testAddFirstAfterClearing() {
        LinkedListDeque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addFirst(10);
        deque.addLast(20);

        deque.removeFirst();
        deque.removeLast();

        assertThat(deque.size()).isEqualTo(0);
        assertThat(deque.isEmpty()).isTrue();

        deque.addFirst(30);

        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.get(0)).isEqualTo(30);
    }

    @Test
    public void testAddLastAfterClearing() {
        LinkedListDeque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addFirst(40);
        deque.addLast(50);

        deque.removeFirst();
        deque.removeLast();

        assertThat(deque.size()).isEqualTo(0);
        assertThat(deque.isEmpty()).isTrue();

        deque.addLast(60);

        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.get(0)).isEqualTo(60);
    }
    @Test
    public void testEmptyState() {
        LinkedListDeque61B<Integer> result = new LinkedListDeque61B<>();
        assertThat(result.isEmpty()).isTrue();
        result.addFirst(2);
        assertThat((result.isEmpty())).isFalse();
    }

    @Test
    public void testSizeTracking() {
        LinkedListDeque61B<String> list = new LinkedListDeque61B<>();
        assertThat(list.size()).isEqualTo(0);
        list.addFirst("yoo");
        assertThat(list.size()).isEqualTo(1);
        list.removeLast();
        assertThat(list.size()).isEqualTo(0);
        list.removeLast();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void testGetOutOfBounds() {
        LinkedListDeque61B<String> list = new LinkedListDeque61B<>();
        list.addFirst("hello");
        assertThat(list.get(-1)).isNull();
        assertThat(list.get(1)).isNull();
        assertThat(list.get(38479347)).isNull();
    }

    @Test
    public void testRemoveFirstElement() {
        Deque61B<String> list = new LinkedListDeque61B<>();
        list.addFirst("abc");
        list.addFirst("def");
        assertThat(list.toList()).containsExactly("def", "abc").inOrder();
        list.removeFirst();
        assertThat(list.toList()).containsExactly("abc").inOrder();
        list.removeFirst();
        assertThat(list.toList()).isEmpty();
    }

    @Test
    public void testAddFirstMultipleElements() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("back");
        assertThat(lld1.toList()).containsExactly("back").inOrder();

        lld1.addFirst("middle");
        assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

        lld1.addFirst("front");
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

    }

    @Test
    public void testGetRecursiveOutOfBounds() {
        LinkedListDeque61B<String> list = new LinkedListDeque61B<>();
        list.addFirst("hi");
        assertThat(list.getRecursive(-1)).isNull();
        assertThat(list.getRecursive(1)).isNull();
        assertThat(list.getRecursive(3958475)).isNull();
    }


    @Test
    public void testAddLastMultipleElements() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    public void testAddFirstAndLastTogether() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(0);
        lld1.addLast(1);
        lld1.addFirst(-1);
        lld1.addLast(2);
        lld1.addFirst(-2);

        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    @Test
    public void testToListConversion() {
        LinkedListDeque61B<String> list = new LinkedListDeque61B<>();
        List<String> res = list.toList();
        assertThat(res).isEmpty();
        assertThat(res).isNotNull();
        list.addFirst("hi");
        list.addLast("hey");
        list.addLast("wsg");
        List<String> res2 = list.toList();
        assertThat(res2).containsExactly("hi", "hey", "wsg").inOrder();

    }

}