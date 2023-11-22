package agility.tungphan.poc.mylibrary.models

import java.util.UUID

class RegistrationData(
    val userId: String = UUID.randomUUID().toString()
)