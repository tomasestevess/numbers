import com.aor.numbers.ListAggregator
import com.aor.numbers.ListDeduplicator
import com.aor.numbers.ListSorter

class ListAggregatorSpockTest {
    private def list

    def helper() {
        list = Arrays.asList(1,2,4,2,5)
    }

    def "test for sum method"(){
        given:
            def aggregator = new ListAggregator()

        when:
            def sum = aggregator.sum(list)

        then:
            14 == sum
    }

    def "test for max method"(){
        given:
            def aggregator = new ListAggregator()
        when:
            def max = aggregator.max(list)

        then:
            5 == max
    }

    def "test for min method"(){
        given:
            def aggregator = new ListAggregator()

        when:
            def max = aggregator.min(list)

        then:
            1 == max
    }

    def "test for distinct method"(){
        given:
             def aggregator = new ListAggregator()
            def deduplicator = new ListDeduplicator(new ListSorter())

        when:
            def distinct = aggregator.distinct(list, deduplicator)

        then:
            4 == distinct
    }

    def "test for max_bug_7263"(){
        given:
            def aggregator = new ListAggregator()

        when:
            def max = aggregator.max(Arrays.asList(-1, -4, -5))

        then:
            -1 == max
    }

    def "test for distinct_bug_8726"(){
        given:
            def deduplicator = Mock(GenericListDeduplicator)
            def aggregator = new ListAggregator()
            deduplicator.deduplicate() >> Arrays.asList(1, 2, 4)
        when:
            def distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator)
        then:
            3 == distinct
    }


}
