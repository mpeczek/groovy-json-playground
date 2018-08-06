package org.marcin.peczek.spock

import org.marcin.peczek.helpers.TestDataProvider
import spock.lang.Specification


class JsonTestDataSpec extends Specification {

    private slurper = new groovy.json.JsonSlurper()
    private jsonTestData = slurper.parse(getClass().getResource("/requestData/requestData.json"))

    def "get json test data"() {

        given:
        def id = TestDataProvider.getIndex(jsonTestData, 'test-102')

        when:
        def last_name = jsonTestData[id].gender

        then:
        last_name == 'Female'
    }

    def "compare json files"() {

        when:
        def response1 = slurper.parse(getClass().getResource("/responseData/response1.json"))
        def response2 = slurper.parse(getClass().getResource("/responseData/response2.json"))

        then:
        response1 == response2
    }
}