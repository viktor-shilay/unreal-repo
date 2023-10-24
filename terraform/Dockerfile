# Use an official Terraform base image
FROM hashicorp/terraform:light

# Set the working directory
WORKDIR /terraform

# Copy your Terraform configuration files to the container
COPY . /terraform

# Make the entrypoint.sh script executable
RUN chmod +x entrypoint.sh

# Entrypoint for running Terraform commands
ENTRYPOINT ["/terraform/entrypoint.sh"]

