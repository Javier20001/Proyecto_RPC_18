import axios from "axios";
import Swal from "sweetalert2";

export const handleAxiosError = (error: unknown, defaultMessage: string) => {
  if (axios.isAxiosError(error) && error.response) {
    const data = error.response.data;
    let errorMessage = defaultMessage;

    if (data && typeof data === "string") {
      errorMessage = data;
    } else if (data.violations && Array.isArray(data.violations)) {
      errorMessage = data.violations
        .map(
          (violation: { field: string; message: string }) =>
            `${violation.message}`
        )
        .join("\n");
    }

    Swal.fire({
      title: "Error",
      text: errorMessage,
      icon: "error",
      confirmButtonText: "Continue",
    });
    return errorMessage;
  } else {
    Swal.fire({
      title: "Error",
      text: defaultMessage,
      icon: "error",
      confirmButtonText: "Continue",
    });
    return defaultMessage;
  }
};
