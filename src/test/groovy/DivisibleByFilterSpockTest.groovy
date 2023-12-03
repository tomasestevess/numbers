import com.aor.numbers.DivisibleByFilter
import spock.lang.Specification


class DivisibleByFilterSpockTest extends Specification{
    def 'accept divide by 5'(){
        given:
            def dbf = new DivisibleByFilter(5)
        when:
            def dividible = Arrays.asList(5,10,15,20,25)
            def notDivisible = Arrays.asList(1,2,3,4,6)
        then:
            dividible.every { it -> dbf.accept(it) }
            notDividible.every { it -> !dbf.accept(it) }
    }
}
