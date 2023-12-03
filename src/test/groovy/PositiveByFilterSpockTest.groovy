import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveByFilterSpockTest extends Specification{
    private def list
    private def positives
    private def notPositives

    def helper() {
        pf = new PositiveFilter()
        positives = Arrays.asList(1,2,3,4,5)
        nonPositives = Arrays.asList(-1,-2,-3,-4,-5)
    }

    def "Test for positive list"(){
        positives.every {it->pf.accept(it)}
    }

    def "Test for non positives list"(){
        notPositives.every {it->!pf.accept(it)}
    }

}
