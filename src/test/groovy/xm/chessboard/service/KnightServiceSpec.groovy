package xm.chessboard.service

import xm.chessboard.helper.KnightNextStepCalculatorHelper

import spock.lang.Specification
import spock.lang.Unroll

class KnightServiceSpec extends Specification {

    KnightService service
    KnightNextStepCalculatorHelper helper

    def setup() {
        helper = new KnightNextStepCalculatorHelper()
        service = new KnightService(helper)
    }

    @Unroll
    def "Should return no solutions for given starting position and ending position in 3 moves max"() {
        when:
            def response = service.calculateSolutionPaths(startingPosition, endingPosition)

        then:
            response.size() == 0

        where:
            startingPosition | endingPosition
            'A1'             | 'H8'
            'G2'             | 'B7'
            'B2'             | 'F8'
            'H8'             | 'A4'
    }

    @Unroll
    def "Should calculate and return paths for given starting point and ending point in 3 moves max"() {
        when:
            def response = service.calculateSolutionPaths(startingPosition, endingPosition)

        then:
            response.size() > 0
            response.containsAll(containedPaths)

        where:
           startingPosition | endingPosition | containedPaths
            'A1'            | 'E6'           | ['A1 -> C2 -> D4 -> E6', 'A1 -> B3 -> C5 -> E6', 'A1 -> B3 -> D4 -> E6']
            'A1'            | 'B3'           | ['A1 -> B3']
    }
}
