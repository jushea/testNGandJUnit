package ru.experiment.rest;

public class SchemaJson {
    static final String PETSCHEMAJSON = "{\n" +
            "  \"$schema\": \"http://json-schema.org/draft-04/schema\",\n" +
            "  \"title\": \"Pet\",\n" +
            "  \"description\": \"Array of pets by status\",\n" +
            "  \"type\": \"array\",\n" +
            "  \"properties\": {\n" +
            "    \"id\": {\n" +
            "      \"description\": \"The unique identifier for a FIND_BY_STATUS\",\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"name\": {\n" +
            "      \"description\": \"Name of the FIND_BY_STATUS\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"category\": {\n" +
            "      \"category\": \"http://jsonschema.net/category#\",\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"id\": {\n" +
            "          \"id\": \"http://jsonschema.net/category/id#\",\n" +
            "          \"type\": \"integer\"\n" +
            "        },\n" +
            "        \"name\": {\n" +
            "          \"name\": \"http://jsonschema.net/category/name#\",\n" +
            "          \"type\": \"string\"\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"photoUrls\": {\n" +
            "      \"type\": \"array\",\n" +
            "      \"items\": {\"type\": \"string\"}\n" +
            "    },\n" +
            "    \"tags\": {\n" +
            "      \"id\": \"http://jsonschema.net/tags#\",\n" +
            "      \"type\": \"array\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"id\": \"http://jsonschema.net/tags/0#\",\n" +
            "          \"type\": \"object\",\n" +
            "          \"properties\": {\n" +
            "            \"id\": {\n" +
            "              \"id\": \"http://jsonschema.net/tags/0/id#\",\n" +
            "              \"type\": \"integer\"\n" +
            "            },\n" +
            "            \"name\": {\n" +
            "              \"id\": \"http://jsonschema.net/tags/0/name#\",\n" +
            "              \"type\": \"string\"\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"status\": {\n" +
            "      \"type\": \"string\"\n" +
            "    }\n" +
            "  }\n" +
            "}";
    static final String STORESCHEMAJSON = "{\n" +
            "  \"$schema\": \"http://json-schema.org/draft-04/schema\",\n" +
            "  \"title\": \"Store\",\n" +
            "  \"type\": \"object\",\n" +
            "  \"properties\": {\n" +
            "    \"id\": {\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"petId\": {\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"quantity\": {\n" +
            "      \"type\": \"integer\"\n" +
            "    },\n" +
            "    \"shipDate\": {\n" +
            "      \"type\": \"string\",\n" +
            "      \"format\": \"date-time\"\n" +
            "    },\n" +
            "    \"status\": {\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"complete\": {\n" +
            "      \"type\": \"boolean\"\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
