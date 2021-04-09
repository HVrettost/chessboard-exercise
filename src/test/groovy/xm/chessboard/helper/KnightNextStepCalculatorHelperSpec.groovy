package xm.chessboard.helper

import spock.lang.Specification
import spock.lang.Unroll

class KnightNextStepCalculatorHelperSpec extends Specification {

    KnightNextStepCalculatorHelper helper

    def setup() {
        helper = new KnightNextStepCalculatorHelper()
    }

    @Unroll
    def "Should throw exception if position passed as parameter is not valid / not a valid case scenario because position is validated before method call"() {
        when:
            helper.calculateNextStepPositionsOfKnight(position)

        then:
            def ex = thrown(IllegalArgumentException)

        and:
            ex.message == 'Chessboard position is not valid'

        where:
            position << ['A0', 'B0', 'P1', 'H10', 'hello', 'You are tearing me apart Lisa', 'h7']
    }

    @Unroll
    def "Should return Set of next step positions for a given input position"() {
        when:
            def response = helper.calculateNextStepPositionsOfKnight(position)

        then:
            with (response) {
                size() == expectedResponse.size()
                each { expectedResponse.contains(it) }
            }

        where:
            position | expectedResponse
            'A1'     | ['B3', 'C2']
            'H1'     | ['G3', 'F2']
            'D4'     | ['B5', 'E6', 'E2', 'C2', 'F5', 'F3', 'B3', 'C6']
            'C1'     | ['B3', 'D3', 'A2', 'E2']
            'H5'     | ['G7', 'G3', 'F4', 'F6']
    }
}
