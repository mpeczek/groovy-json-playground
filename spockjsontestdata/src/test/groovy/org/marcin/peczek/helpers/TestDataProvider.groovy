package org.marcin.peczek.helpers

class TestDataProvider {

    static getIndex(jsonTestData, jsonTestDataId) {

        def index

        jsonTestData.id.eachWithIndex {id, i ->
            if (id == jsonTestDataId) {
                index = i
            }
        }
        return index
    }
}
